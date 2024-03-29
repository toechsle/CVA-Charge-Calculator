package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DeleteIntermediateResultsTransactionEntityServiceImpl implements DeleteIntermediateResultsTransactionEntityService {

    @Autowired
    private IntermediateResultsTransactionRepository intermediateResultsTransactionRepository;

    @Transactional
    public void execute() {
        intermediateResultsTransactionRepository.deleteAll();
    }
}
