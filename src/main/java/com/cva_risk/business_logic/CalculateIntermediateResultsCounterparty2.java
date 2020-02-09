package com.cva_risk.business_logic;

import com.cva_risk.database_access.services.*;
import com.cva_risk.model.IntermediateResultsCounterparty;
import com.cva_risk.utils.Flags;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@SpringComponent
public class CalculateIntermediateResultsCounterparty2 {

    @Autowired
    private GetInputTransactionResMaturityAndNominalValueOfSingleCVAHedgesForCounterpartyServiceImpl getInputTransactionResMaturityAndNominalValueOfSingleCVAHedgesForCounterpartyService;

    @Autowired
    private GetIntermediateResultsCounterpartyAllServiceImpl getIntermediateResultsCounterpartyAllService;

    @Autowired
    private GetIntermediateResultsNettingSetResMaturityAndNominalValueOfNettingSetsWithCounterpartyServiceImpl getIntermediateResultsNettingSetResMaturityAndNominalValueOfNettingSetsWithCounterpartyService;

    @Autowired
    private GetIntermediateResultsNettingSetEADOfNettingSetsWithCounterpartyServiceImpl getIntermediateResultsNettingSetEADOfNettingSetsWithCounterpartyService;

    @Autowired
    private UpdateIntermediateResultsCounterpartyServiceImpl updateIntermediateResultsCounterpartyService;


    public void execute(){

        List<IntermediateResultsCounterparty> intermediateResultsCounterpartyList = getIntermediateResultsCounterpartyAllService.findAllIntermediateResultsCounterparties();

        for (IntermediateResultsCounterparty intermediateResultsCounterparty : intermediateResultsCounterpartyList) {

            if (Flags.BAIS == false) {
                calculateEffectiveResidualMaturityForCounterparty(intermediateResultsCounterparty);
                calculateEADForCounterparty(intermediateResultsCounterparty);
                calculateEADDiscountedForCounterparty(intermediateResultsCounterparty);
            }

            if (Flags.HEDGING == true) {
                calculateMHedgeTimesB(intermediateResultsCounterparty);
            }


            updateIntermediateResultsCounterpartyService.updateIntermediateResultsCounterparty(intermediateResultsCounterparty);

        }

    }

    private void calculateEffectiveResidualMaturityForCounterparty(IntermediateResultsCounterparty intermediateResultsCounterparty) {
        List<Object[]> residualMaturitiesAndNominalValues = getIntermediateResultsNettingSetResMaturityAndNominalValueOfNettingSetsWithCounterpartyService.find(intermediateResultsCounterparty);
        Double sumProductOfNominalValueAndResidualMaturity = 0.0;
        Double sumOfNominalValues = 0.0;
        for (Object[] obj : residualMaturitiesAndNominalValues) {
            sumOfNominalValues += (Double) obj[1];
            sumProductOfNominalValueAndResidualMaturity += (Double) obj[0] * (Double) obj[1];
        }
        Double residualMaturityForCounterparty = sumProductOfNominalValueAndResidualMaturity/sumOfNominalValues;
        Double effectiveResidualMaturityForCounterparty = Math.max(1.0, residualMaturityForCounterparty);
        intermediateResultsCounterparty.setEffectiveResidualMaturity(effectiveResidualMaturityForCounterparty);
    }

    private void calculateEADForCounterparty(IntermediateResultsCounterparty intermediateResultsCounterparty) {
        List<Double> ListOfEADsAfterCollateral = getIntermediateResultsNettingSetEADOfNettingSetsWithCounterpartyService.find(intermediateResultsCounterparty);
        Double eadForCounterparty = 0.0;
        for (Double amount : ListOfEADsAfterCollateral) {
            eadForCounterparty += amount;
        }
        intermediateResultsCounterparty.setEad(eadForCounterparty);
    }

    private void calculateEADDiscountedForCounterparty(IntermediateResultsCounterparty intermediateResultsCounterparty) {
        Double eadForCounterparty = intermediateResultsCounterparty.getEad();
        Double effectiveResidualMaturityForCounterparty = intermediateResultsCounterparty.getEffectiveResidualMaturity();
        Double discountFactor = (1 - Math.exp(-0.05 * effectiveResidualMaturityForCounterparty))/(0.05 * effectiveResidualMaturityForCounterparty);
        Double eadDiscountedForCounterparty = discountFactor * eadForCounterparty;
        intermediateResultsCounterparty.setEadDiscounted(eadDiscountedForCounterparty);
    }

    private void calculateMHedgeTimesB(IntermediateResultsCounterparty intermediateResultsCounterparty) {
        int counterpartyId = intermediateResultsCounterparty.getId();
        List<Object[]> residualMaturitiesAndNominalValues = getInputTransactionResMaturityAndNominalValueOfSingleCVAHedgesForCounterpartyService.find(counterpartyId);
        Integer residualMaturityOfSingleCVAHedge;
        Double mHedge;
        Double discountFactor;
        Double mHedgeTimesB = 0.0;
        for (Object[] obj : residualMaturitiesAndNominalValues) {
            residualMaturityOfSingleCVAHedge = (Integer) obj[0];
            mHedge = residualMaturityOfSingleCVAHedge/365.0;
            discountFactor = (1 - Math.exp(-0.05 * mHedge))/(0.05 * mHedge);
            mHedgeTimesB += mHedge * discountFactor * (Double) obj[1];
        }
        intermediateResultsCounterparty.setmHedgeTimesB(mHedgeTimesB);
    }


}
