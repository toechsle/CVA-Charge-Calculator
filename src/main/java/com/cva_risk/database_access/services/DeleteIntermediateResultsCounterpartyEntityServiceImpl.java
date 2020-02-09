package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsCounterpartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DeleteIntermediateResultsCounterpartyEntityServiceImpl implements DeleteIntermediateResultsCounterpartyEntityService {

    @Autowired
    private IntermediateResultsCounterpartyRepository intermediateResultsCounterpartyRepository;

    @Transactional
    public void execute() {
        intermediateResultsCounterpartyRepository.deleteAll();
    }
}
