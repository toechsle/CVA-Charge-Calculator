package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsNettingSetRepository;
import com.cva_risk.model.IntermediateResultsNettingSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GetIntermediateResultsNettingSetAllServiceImpl implements GetIntermediateResultsNettingSetAllService {

    @Autowired
    private IntermediateResultsNettingSetRepository intermediateResultsNettingSetRepository;

    @Transactional(readOnly = true)
    public List<IntermediateResultsNettingSet> findAllIntermediateResultsNettingSets() {
        return intermediateResultsNettingSetRepository.findAll();
    }

}
