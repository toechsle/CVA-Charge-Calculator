package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GetNumberOfIntermediateResultsTransactionInDatabaseServiceImpl implements GetNumberOfIntermediateResultsTransactionInDatabaseService {

    @Autowired
    private IntermediateResultsTransactionRepository intermediateResultsTransactionRepository;

    @Transactional(readOnly = true)
    public int countIntermediateResultsTransactionInDatabase() {
        return (int) intermediateResultsTransactionRepository.count();
    }

}
