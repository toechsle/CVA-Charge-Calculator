package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsCounterpartyRepository;
import com.cva_risk.model.IntermediateResultsCounterparty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UpdateIntermediateResultsCounterpartyServiceImpl implements UpdateIntermediateResultsCounterpartyService {

    @Autowired
    private IntermediateResultsCounterpartyRepository intermediateResultsCounterpartyRepository;


    @Transactional
    public void updateIntermediateResultsCounterparty(IntermediateResultsCounterparty intermediateResultsCounterparty) {

        intermediateResultsCounterpartyRepository.save(intermediateResultsCounterparty);

    }


}
