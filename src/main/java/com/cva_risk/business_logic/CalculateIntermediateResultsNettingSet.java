package com.cva_risk.business_logic;

import com.cva_risk.database_access.services.*;
import com.cva_risk.model.InputCollateral;
import com.cva_risk.model.IntermediateResultsCounterparty;
import com.cva_risk.model.IntermediateResultsNettingSet;
import com.cva_risk.model.IntermediateResultsTransaction;
import com.cva_risk.utils.Flags;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@SpringComponent
public class CalculateIntermediateResultsNettingSet {

    @Autowired
    private GetIntermediateResultsTransactionMinimalNSServiceImpl getIntermediateResultsTransactionMinimalNSService;

    @Autowired
    private GetIntermediateResultsTransactionInNSServiceImpl getIntermediateResultsTransactionInNSService;

    @Autowired
    private GetIntermediateResultsTransactionCounterpartyForNSServiceImpl getIntermediateResultsTransactionCounterpartyForNSService;

    @Autowired
    private GetInputTransactionResidualMaturityServiceImpl getInputTransactionResidualMaturityService;

    @Autowired
    private GetInputTransactionNominalValueServiceImpl getInputTransactionNominalValueService;

    @Autowired
    private GetInputTransactionInNSMarketValuesServiceImpl getInputTransactionInNSMarketValuesService;

    @Autowired
    private GetInputTransactionInNSNominalValuesAndResidualMaturitiesServiceImpl getInputTransactionInNSNominalValuesAndResidualMaturitiesService;

    @Autowired
    private GetInputTransactionNSIdsServiceImpl getInputTransactionNSIdsService;

    @Autowired
    private GetInputCollateralAllServiceImpl getInputCollateralAllService;

    @Autowired
    private AddIntermediateResultsNettingSetServiceImpl addIntermediateResultsNettingSetService;


    public void execute(){

        IntermediateResultsNettingSet intermediateResultsNettingSetDAO = new IntermediateResultsNettingSet();

        List<IntermediateResultsTransaction> listOfMinimalNettingSets = getIntermediateResultsTransactionMinimalNSService.find();
        List<Integer> listOfIdsOfNormalNettingSets = getInputTransactionNSIdsService.find();
        List<InputCollateral> listOfCollateral = getInputCollateralAllService.findAllInputCollateral();


        for (IntermediateResultsTransaction intermediateResultsTransaction : listOfMinimalNettingSets) {

            int idOfTransaction = intermediateResultsTransaction.getId();
            intermediateResultsNettingSetDAO.setId(idOfTransaction);

            IntermediateResultsCounterparty intermediateResultsCounterparty = intermediateResultsTransaction.getIntermediateResultsCounterparty();
            intermediateResultsNettingSetDAO.setIntermediateResultsCounterparty(intermediateResultsCounterparty);

            Double nominalValue = getInputTransactionNominalValueService.find(idOfTransaction);
            intermediateResultsNettingSetDAO.setNominalValue(nominalValue);

            intermediateResultsNettingSetDAO.setExposureValueBeforeCollateral(calculateExposureValueBeforeCollateralForMinimalNS(intermediateResultsTransaction));
            calculateExposureValueAfterCollateral(intermediateResultsNettingSetDAO, listOfCollateral);

            Double residualMaturity = getResidualMaturityForMinimalNS(intermediateResultsTransaction);
            intermediateResultsNettingSetDAO.setResidualMaturity(residualMaturity);

            if (Flags.BAIS == true) {
                Double effectiveResidualMaturity = Math.max(1.0, residualMaturity);
                intermediateResultsNettingSetDAO.setEffectiveResidualMaturity(effectiveResidualMaturity);
                calculateDiscountedExposureValueAfterCollateral(intermediateResultsNettingSetDAO);
            }


            addIntermediateResultsNettingSetService.saveIntermediateResultsNettingSet(intermediateResultsNettingSetDAO);

        }


        for (Integer nettingSetId : listOfIdsOfNormalNettingSets) {

            intermediateResultsNettingSetDAO.setId(nettingSetId);

            IntermediateResultsCounterparty intermediateResultsCounterparty = getIntermediateResultsTransactionCounterpartyForNSService.findIntermediateResultsCounterpartyForNSWithId(nettingSetId);
            intermediateResultsNettingSetDAO.setIntermediateResultsCounterparty(intermediateResultsCounterparty);

            List<IntermediateResultsTransaction> listOfTransactionsInNS = getIntermediateResultsTransactionInNSService.find(nettingSetId);
            List<Double> currentMarketValues = getInputTransactionInNSMarketValuesService.find(nettingSetId);
            List<Object[]> nominalValuesAndResidualMaturities = getInputTransactionInNSNominalValuesAndResidualMaturitiesService.find(nettingSetId);

            Double netReplacementCost = calculateNetReplacementCostOfNS(currentMarketValues);
            intermediateResultsNettingSetDAO.setNetReplacementCost(netReplacementCost);

            Double grossReplacementCost = calculateGrossReplacementCostOfNS(listOfTransactionsInNS);
            intermediateResultsNettingSetDAO.setGrossReplacementCost(grossReplacementCost);

            Double netToGrossRatio = netReplacementCost/grossReplacementCost;
            intermediateResultsNettingSetDAO.setNetToGrossRatio(netToGrossRatio);

            Double pceGross = calculatePCEGrossOfNS(listOfTransactionsInNS);
            intermediateResultsNettingSetDAO.setPceGross(pceGross);

            Double pceRed = calculatePCERedOfNS(netToGrossRatio, pceGross);
            intermediateResultsNettingSetDAO.setPceRed(pceRed);

            Double exposureValueBeforeCollateral = calculateExposureValueBeforeCollateral(intermediateResultsNettingSetDAO);
            intermediateResultsNettingSetDAO.setExposureValueBeforeCollateral(exposureValueBeforeCollateral);

            calculateExposureValueAfterCollateral(intermediateResultsNettingSetDAO, listOfCollateral);

            Double nominalValue = calculateNominalValueOfNS(nominalValuesAndResidualMaturities);
            intermediateResultsNettingSetDAO.setNominalValue(nominalValue);

            Double residualMaturity = calculateResidualMaturityOfNS(nominalValuesAndResidualMaturities);
            intermediateResultsNettingSetDAO.setResidualMaturity(residualMaturity);

            if (Flags.BAIS == true) {
                Double effectiveResidualMaturity = Math.max(1.0, residualMaturity);
                intermediateResultsNettingSetDAO.setEffectiveResidualMaturity(effectiveResidualMaturity);
                calculateDiscountedExposureValueAfterCollateral(intermediateResultsNettingSetDAO);
            }


            addIntermediateResultsNettingSetService.saveIntermediateResultsNettingSet(intermediateResultsNettingSetDAO);

        }

    }


    private Double calculateExposureValueBeforeCollateralForMinimalNS(IntermediateResultsTransaction intermediateResultsTransaction) {
        Double exposureValueBeforeCollateral = intermediateResultsTransaction.getCurrentReplacementCost() + intermediateResultsTransaction.getAddOn();
        return exposureValueBeforeCollateral;
    }

    private Double getResidualMaturityForMinimalNS(IntermediateResultsTransaction intermediateResultsTransaction) {
        int id = intermediateResultsTransaction.getId();
        Integer residualMaturityInDays = getInputTransactionResidualMaturityService.find(id);
        Double residualMaturity = residualMaturityInDays/365.0;
        return residualMaturity;
    }

    private Double calculateNetReplacementCostOfNS(List<Double> currentMarketValues) {
        Double netReplacementCost = 0.0;
        for (Double marketValue : currentMarketValues) {
            netReplacementCost += marketValue;
        }
        netReplacementCost = Math.max(0.0, netReplacementCost);
        return netReplacementCost;
    }

    private Double calculateGrossReplacementCostOfNS(List<IntermediateResultsTransaction> transactions) {
        Double grossReplacementCost = 0.0;
        for (IntermediateResultsTransaction transaction : transactions) {
            grossReplacementCost += transaction.getCurrentReplacementCost();
        }
        return grossReplacementCost;
    }

    private Double calculatePCEGrossOfNS(List<IntermediateResultsTransaction> transactions) {
        Double pceGross = 0.0;
        for (IntermediateResultsTransaction transaction : transactions) {
            pceGross += transaction.getAddOn();
        }
        return pceGross;
    }

    private Double calculatePCERedOfNS(Double netToGrossRatio, Double pceGross) {
        Double pceRed = 0.4 * pceGross + 0.6 * netToGrossRatio * pceGross;
        return pceRed;
    }

    private Double calculateExposureValueBeforeCollateral(IntermediateResultsNettingSet intermediateResultsNettingSet) {
        Double exposureValueBeforeCollateral = intermediateResultsNettingSet.getNetReplacementCost() + intermediateResultsNettingSet.getPceRed();
        return exposureValueBeforeCollateral;
    }

    private void calculateExposureValueAfterCollateral(IntermediateResultsNettingSet intermediateResultsNettingSet, List<InputCollateral> listOfCollateral) {
        Double netCollateralReceived = 0.0;
        int nettingSetId = intermediateResultsNettingSet.getId();
        for (InputCollateral collateral : listOfCollateral) {
            if (collateral.getId() == nettingSetId) {
                netCollateralReceived = collateral.getNetCollateralReceived();
                break;
            }
        }
        Double exposureValueAfterCollateral = Math.max(0.0, intermediateResultsNettingSet.getExposureValueBeforeCollateral() - netCollateralReceived);
        intermediateResultsNettingSet.setExposureValueAfterCollateral(exposureValueAfterCollateral);
    }

    private Double calculateNominalValueOfNS(List<Object[]> nominalValuesAndResidualMaturities) {
        Double nominalValue = 0.0;
        for (Object[] obj : nominalValuesAndResidualMaturities) {
            nominalValue += (Double) obj[0];
        }
        return nominalValue;
    }

    private Double calculateResidualMaturityOfNS(List<Object[]> nominalValuesAndResidualMaturities) {
        Double sumOfNominalValues = 0.0;
        Double sumProductOfNominalValueAndResidualMaturity = 0.0;
        Integer residualMaturityOfTransaction;
        for (Object[] obj : nominalValuesAndResidualMaturities) {
            sumOfNominalValues += (Double) obj[0];
            residualMaturityOfTransaction = (Integer) obj[1];
            sumProductOfNominalValueAndResidualMaturity += (Double) obj[0] * residualMaturityOfTransaction;
        }
        Double residualMaturity = (sumProductOfNominalValueAndResidualMaturity/sumOfNominalValues)/365;
        return residualMaturity;
    }

    private void calculateDiscountedExposureValueAfterCollateral(IntermediateResultsNettingSet intermediateResultsNettingSet) {
        Double exposureValueAfterCollateral = intermediateResultsNettingSet.getExposureValueAfterCollateral();
        Double effectiveResidualMaturity = intermediateResultsNettingSet.getEffectiveResidualMaturity();
        Double discountFactor = (1 - Math.exp(-0.05 * effectiveResidualMaturity))/(0.05 * effectiveResidualMaturity);
        Double discountedExposureValueAfterCollateral = discountFactor * exposureValueAfterCollateral;
        intermediateResultsNettingSet.setDiscountedExposureValueAfterCollateral(discountedExposureValueAfterCollateral);
    }


}
