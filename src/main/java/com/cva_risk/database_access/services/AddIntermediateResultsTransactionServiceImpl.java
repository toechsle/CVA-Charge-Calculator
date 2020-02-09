package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsTransactionRepository;
import com.cva_risk.model.IntermediateResultsTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AddIntermediateResultsTransactionServiceImpl implements AddIntermediateResultsTransactionService {

    @Autowired
    private IntermediateResultsTransactionRepository intermediateResultsTransactionRepository;

    @Transactional
    public void saveIntermediateResultsTransaction(IntermediateResultsTransaction intermediateResultsTransactionDAO) {

        IntermediateResultsTransaction intermediateResultsTransaction = new IntermediateResultsTransaction();

        intermediateResultsTransaction.setId(intermediateResultsTransactionDAO.getId());
        intermediateResultsTransaction.setIntermediateResultsCounterparty(intermediateResultsTransactionDAO.getIntermediateResultsCounterparty());
        intermediateResultsTransaction.setVolatilityRate(intermediateResultsTransactionDAO.getVolatilityRate());
        intermediateResultsTransaction.setCurrentReplacementCost(intermediateResultsTransactionDAO.getCurrentReplacementCost());
        intermediateResultsTransaction.setAddOn(intermediateResultsTransactionDAO.getAddOn());
        intermediateResultsTransaction.setInputTransaction(intermediateResultsTransactionDAO.getInputTransaction());


        intermediateResultsTransactionRepository.save(intermediateResultsTransaction);

    }

}
