package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsCounterpartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GetNumberOfIntermediateResultsCounterpartyInDatabaseServiceImpl implements GetNumberOfIntermediateResultsCounterpartyInDatabaseService {

    @Autowired
    private IntermediateResultsCounterpartyRepository intermediateResultsCounterpartyRepository;

    @Transactional(readOnly = true)
    public int countIntermediateResultsCounterpartyInDatabase() {
        return (int) intermediateResultsCounterpartyRepository.count();
    }

}
