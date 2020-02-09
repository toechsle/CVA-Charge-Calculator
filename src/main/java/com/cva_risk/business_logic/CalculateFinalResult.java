package com.cva_risk.business_logic;

import com.cva_risk.database_access.services.AddFinalResultServiceImpl;
import com.cva_risk.database_access.services.GetInputTransactionResMaturityAndNominalValueOfIndexCVAHedgesServiceImpl;
import com.cva_risk.database_access.services.GetIntermediateResultsCounterpartyAllServiceImpl;
import com.cva_risk.database_access.services.GetIntermediateResultsNettingSetEffResMatAndDiscEADAfterCollOfNettingSetsWithCounterpartyServiceImpl;
import com.cva_risk.model.FinalResult;
import com.cva_risk.model.IntermediateResultsCounterparty;
import com.cva_risk.utils.Flags;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@SpringComponent
public class CalculateFinalResult {

    @Autowired
    private GetIntermediateResultsCounterpartyAllServiceImpl getIntermediateResultsCounterpartyAllService;

    @Autowired
    private GetIntermediateResultsNettingSetEffResMatAndDiscEADAfterCollOfNettingSetsWithCounterpartyServiceImpl getIntermediateResultsNettingSetEffResMatAndDiscEADAfterCollOfNettingSetsWithCounterpartyService;

    @Autowired
    GetInputTransactionResMaturityAndNominalValueOfIndexCVAHedgesServiceImpl getInputTransactionResMaturityAndNominalValueOfIndexCVAHedgesService;

    @Autowired
    private AddFinalResultServiceImpl addFinalResultService;

    private Double firstTerm;
    private Double secondTerm;
    private Double termUnderSquareRoot;
    private Double finalResult;


    public void execute() {

        FinalResult finalResultDAO = new FinalResult();
        firstTerm = 0.0;
        secondTerm = 0.0;

        List<IntermediateResultsCounterparty> intermediateResultsCounterpartyList = getIntermediateResultsCounterpartyAllService.findAllIntermediateResultsCounterparties();

        if (Flags.BAIS == false) {

            for (IntermediateResultsCounterparty intermediateResultsCounterparty : intermediateResultsCounterpartyList) {
                Double weight = intermediateResultsCounterparty.getWeight();
                Double w = weight/100.0;
                Double m = intermediateResultsCounterparty.getEffectiveResidualMaturity();
                Double ead = intermediateResultsCounterparty.getEadDiscounted();
                if (Flags.HEDGING == true) {
                    Double mHedgeTimesB = intermediateResultsCounterparty.getmHedgeTimesB();
                    Double wTimesMHedgeTimesBIndex = calculateWTimesMHedgeTimesBIndex();
                    Double termInBracketsForFirstTerm = Math.max(0.0, m * ead - mHedgeTimesB - wTimesMHedgeTimesBIndex);
                    Double termInBracketsForSecondTerm = Math.max(0.0, m * ead - mHedgeTimesB);
                    firstTerm += 0.5 * w * termInBracketsForFirstTerm;
                    secondTerm += 0.75 * w * w * termInBracketsForSecondTerm * termInBracketsForSecondTerm;
                }
                else {
                    firstTerm += 0.5 * w * (m * ead);
                    secondTerm += 0.75 * w * w * (m * ead) * (m * ead);
                }
            }

        }
        else {

            for (IntermediateResultsCounterparty intermediateResultsCounterparty : intermediateResultsCounterpartyList) {
                Double weight = intermediateResultsCounterparty.getWeight();
                Double w = weight/100.0;
                Double mTimesEAD = calculateMTimesEADWithBAISMethod(intermediateResultsCounterparty);
                if (Flags.HEDGING == true) {
                    Double mHedgeTimesB = intermediateResultsCounterparty.getmHedgeTimesB();
                    Double wTimesMHedgeTimesBIndex = calculateWTimesMHedgeTimesBIndex();
                    Double termInBracketsForFirstTerm = Math.max(0.0, mTimesEAD - mHedgeTimesB - wTimesMHedgeTimesBIndex);
                    Double termInBracketsForSecondTerm = Math.max(0.0, mTimesEAD - mHedgeTimesB);

                    firstTerm += 0.5 * w * termInBracketsForFirstTerm;
                    secondTerm += 0.75 * w * w * termInBracketsForSecondTerm * termInBracketsForSecondTerm;
                }
                else {
                    firstTerm += 0.5 * w * mTimesEAD;
                    secondTerm += 0.75 * w * w * mTimesEAD * mTimesEAD;
                }
            }

        }

        firstTerm = firstTerm * firstTerm;
        termUnderSquareRoot = firstTerm + secondTerm;
        finalResult = 2.33 * Math.sqrt(termUnderSquareRoot);
        finalResultDAO.setId(1);
        finalResultDAO.setValue(finalResult);


        addFinalResultService.saveFinalResult(finalResultDAO);

    }


    private Double calculateMTimesEADWithBAISMethod(IntermediateResultsCounterparty intermediateResultsCounterparty) {
        List<Object[]> effResMaturitiesAndDiscEADsAfterColl = getIntermediateResultsNettingSetEffResMatAndDiscEADAfterCollOfNettingSetsWithCounterpartyService.find(intermediateResultsCounterparty);
        Double mTimesEAD = 0.0;
        for (Object[] obj : effResMaturitiesAndDiscEADsAfterColl) {
            mTimesEAD += (Double) obj[0] * (Double) obj[1];
        }
        return mTimesEAD;
    }

    private Double calculateWTimesMHedgeTimesBIndex() {
        List<Object[]> residualMaturitiesAndNominalValues = getInputTransactionResMaturityAndNominalValueOfIndexCVAHedgesService.find();
        Integer residualMaturityOfIndexCVAHedge;
        Double mIndexHedge;
        Double bIndex;
        Double sumProductOfMHedgeAndBIndex = 0.0;
        Double sumOfBIndex = 0.0;
        for (Object[] obj : residualMaturitiesAndNominalValues) {
            residualMaturityOfIndexCVAHedge = (Integer) obj[0];
            mIndexHedge = residualMaturityOfIndexCVAHedge/365.0;
            bIndex = (Double) obj[1];
            sumProductOfMHedgeAndBIndex += mIndexHedge * bIndex;
            sumOfBIndex += bIndex;
        }
        Double mIndexTotal = sumProductOfMHedgeAndBIndex/sumOfBIndex;
        Double discountFactor = (1 - Math.exp(-0.05 * mIndexTotal))/(0.05 * mIndexTotal);
        Double wTimesMHedgeTimesBIndex = 0.007 * mIndexTotal * discountFactor * sumOfBIndex;
        return wTimesMHedgeTimesBIndex;
    }


}
