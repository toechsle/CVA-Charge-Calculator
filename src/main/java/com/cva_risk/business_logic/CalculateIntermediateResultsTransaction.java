package com.cva_risk.business_logic;

import com.cva_risk.database_access.services.AddIntermediateResultsTransactionServiceImpl;
import com.cva_risk.database_access.services.GetInputTransactionAllServiceImpl;
import com.cva_risk.database_access.services.GetIntermediateResultsCounterpartySingleServiceImpl;
import com.cva_risk.model.InputTransaction;
import com.cva_risk.model.IntermediateResultsCounterparty;
import com.cva_risk.model.IntermediateResultsTransaction;
import com.cva_risk.utils.TransactionCategories;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@SpringComponent
public class CalculateIntermediateResultsTransaction {

    @Autowired
    private GetInputTransactionAllServiceImpl getInputTransactionAllService;

    @Autowired
    private GetIntermediateResultsCounterpartySingleServiceImpl getIntermediateResultsCounterpartySingleService;

    @Autowired
    private AddIntermediateResultsTransactionServiceImpl addIntermediateResultsTransactionService;


    public void execute(){

        IntermediateResultsTransaction intermediateResultsTransactionDAO = new IntermediateResultsTransaction();

        List<InputTransaction> inputTransactionList = getInputTransactionAllService.findAllInputTransactions();

        for (InputTransaction inputTransaction : inputTransactionList) {

            intermediateResultsTransactionDAO.setId(inputTransaction.getId());

            int idOfCounterparty = inputTransaction.getInputCounterparty().getId();
            IntermediateResultsCounterparty intermediateResultsCounterparty = getIntermediateResultsCounterpartySingleService.findIntermediateResultsCounterpartyWithId(idOfCounterparty);
            intermediateResultsTransactionDAO.setIntermediateResultsCounterparty(intermediateResultsCounterparty);

            setCurrentReplacementCost(inputTransaction, intermediateResultsTransactionDAO);

            if (inputTransaction.getBasisSwap() == true || (inputTransaction.getOptionWriterPosition() == true && inputTransaction.getNettingSetId() == null)) {
                intermediateResultsTransactionDAO.setVolatilityRate(0.0);
                intermediateResultsTransactionDAO.setAddOn(0.0);
            }
            else {
                setVolatilityRate(inputTransaction, intermediateResultsTransactionDAO);
                setAddOn(inputTransaction, intermediateResultsTransactionDAO);
            }

            intermediateResultsTransactionDAO.setInputTransaction(inputTransaction);


            addIntermediateResultsTransactionService.saveIntermediateResultsTransaction(intermediateResultsTransactionDAO);

        }
        
    }



    private void setVolatilityRate(InputTransaction inputTransaction, IntermediateResultsTransaction intermediateResultsTransactionDAO) {

        Integer residualMaturity = inputTransaction.getResidualMaturity();
        Double residualMaturityInYears = residualMaturity/365.0;
        TransactionCategories category = inputTransaction.getCategory();

        if (residualMaturityInYears <= 1) {
            if (category.equals(TransactionCategories.interestRateContracts)) {
                intermediateResultsTransactionDAO.setVolatilityRate(0.0);
            }
            else if (category.equals(TransactionCategories.contractsConcerningForeignExchangeRatesAndGold)) {
                intermediateResultsTransactionDAO.setVolatilityRate(1.0);
            }
            else if (category.equals(TransactionCategories.contractsConcerningEquities)) {
                intermediateResultsTransactionDAO.setVolatilityRate(6.0);
            }
            else if (category.equals(TransactionCategories.contractsConcerningPreciousMetalsExceptGold)) {
                intermediateResultsTransactionDAO.setVolatilityRate(7.0);
            }
            else {
                intermediateResultsTransactionDAO.setVolatilityRate(10.0);
            }
        }
        else if (residualMaturityInYears > 1 && residualMaturityInYears <= 5) {
            if (category.equals(TransactionCategories.interestRateContracts)) {
                intermediateResultsTransactionDAO.setVolatilityRate(0.5);
            }
            else if (category.equals(TransactionCategories.contractsConcerningForeignExchangeRatesAndGold)) {
                intermediateResultsTransactionDAO.setVolatilityRate(5.0);
            }
            else if (category.equals(TransactionCategories.contractsConcerningEquities)) {
                intermediateResultsTransactionDAO.setVolatilityRate(8.0);
            }
            else if (category.equals(TransactionCategories.contractsConcerningPreciousMetalsExceptGold)) {
                intermediateResultsTransactionDAO.setVolatilityRate(7.0);
            }
            else {
                intermediateResultsTransactionDAO.setVolatilityRate(12.0);
            }
        }
        else {
            if (category.equals(TransactionCategories.interestRateContracts)) {
                intermediateResultsTransactionDAO.setVolatilityRate(1.5);
            }
            else if (category.equals(TransactionCategories.contractsConcerningForeignExchangeRatesAndGold)) {
                intermediateResultsTransactionDAO.setVolatilityRate(7.5);
            }
            else if (category.equals(TransactionCategories.contractsConcerningEquities)) {
                intermediateResultsTransactionDAO.setVolatilityRate(10.0);
            }
            else if (category.equals(TransactionCategories.contractsConcerningPreciousMetalsExceptGold)) {
                intermediateResultsTransactionDAO.setVolatilityRate(8.0);
            }
            else {
                intermediateResultsTransactionDAO.setVolatilityRate(15.0);
            }
        }
    }


    private void setCurrentReplacementCost(InputTransaction inputTransaction, IntermediateResultsTransaction intermediateResultsTransactionDAO) {
        Double currentReplacementCost = Math.max(0.0, inputTransaction.getCurrentMarketValue());
        intermediateResultsTransactionDAO.setCurrentReplacementCost(currentReplacementCost);
    }


    private void setAddOn(InputTransaction inputTransaction, IntermediateResultsTransaction intermediateResultsTransactionDAO) {
        Double AddOn = (inputTransaction.getNominalValue() * intermediateResultsTransactionDAO.getVolatilityRate())/100.0;
        intermediateResultsTransactionDAO.setAddOn(AddOn);
    }


}
