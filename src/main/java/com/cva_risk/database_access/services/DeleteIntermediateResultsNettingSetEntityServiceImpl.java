package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsNettingSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteIntermediateResultsNettingSetEntityServiceImpl implements DeleteIntermediateResultsNettingSetEntityService {

    @Autowired
    private IntermediateResultsNettingSetRepository intermediateResultsNettingSetRepository;

    @Transactional
    public void execute() {
        intermediateResultsNettingSetRepository.deleteAll();
    }

}
