package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsNettingSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GetNumberOfIntermediateResultsNettingSetInDatabaseServiceImpl implements GetNumberOfIntermediateResultsNettingSetInDatabaseService {

    @Autowired
    private IntermediateResultsNettingSetRepository intermediateResultsNettingSetRepository;

    @Transactional(readOnly = true)
    public int countIntermediateResultsNettingSetInDatabase() {
        return (int) intermediateResultsNettingSetRepository.count();
    }
}
