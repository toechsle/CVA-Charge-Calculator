package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputTransactionRepository;
import com.cva_risk.model.InputTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddInputTransactionServiceImpl implements AddInputTransactionService {

    @Autowired
    private InputTransactionRepository inputTransactionRepository;

    @Transactional
    public void saveInputTransaction(InputTransaction inputTransactionDAO){

        InputTransaction inputTransaction = new InputTransaction();

        inputTransaction.setId(inputTransactionDAO.getId());
        inputTransaction.setInputCounterparty(inputTransactionDAO.getInputCounterparty());
        inputTransaction.setNettingSetId(inputTransactionDAO.getNettingSetId());
        inputTransaction.setCategory(inputTransactionDAO.getCategory());
        inputTransaction.setCurrentMarketValue(inputTransactionDAO.getCurrentMarketValue());
        inputTransaction.setNominalValue(inputTransactionDAO.getNominalValue());
        inputTransaction.setResidualMaturity(inputTransactionDAO.getResidualMaturity());
        inputTransaction.setOptionWriterPosition(inputTransactionDAO.getOptionWriterPosition());
        inputTransaction.setBasisSwap(inputTransactionDAO.getBasisSwap());
        inputTransaction.setCvaHedge(inputTransactionDAO.getCvaHedge());
        inputTransaction.setReferencedCounterpartyId(inputTransactionDAO.getReferencedCounterpartyId());
        //inputTransaction.setIntermediateResultsTransaction(inputTransactionDAO.getIntermediateResultsTransaction());

        inputTransactionRepository.save(inputTransaction);

    }
}
