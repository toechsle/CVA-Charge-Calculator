package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsNettingSetRepository;
import com.cva_risk.model.IntermediateResultsCounterparty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GetIntermediateResultsNettingSetResMaturityAndNominalValueOfNettingSetsWithCounterpartyServiceImpl implements GetIntermediateResultsNettingSetResMaturityAndNominalValueOfNettingSetsWithCounterpartyService {

    @Autowired
    private IntermediateResultsNettingSetRepository intermediateResultsNettingSetRepository;

    @Transactional(readOnly = true)
    public List<Object[]> find(IntermediateResultsCounterparty intermediateResultsCounterparty) {
        return intermediateResultsNettingSetRepository.getResidualMaturityAndNominalValueOfNettingSetsWithCounterparty(intermediateResultsCounterparty);
    }

}
