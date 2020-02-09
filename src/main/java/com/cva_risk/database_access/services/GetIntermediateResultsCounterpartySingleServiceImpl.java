package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsCounterpartyRepository;
import com.cva_risk.model.IntermediateResultsCounterparty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GetIntermediateResultsCounterpartySingleServiceImpl implements GetIntermediateResultsCounterpartySingleService {

    @Autowired
    private IntermediateResultsCounterpartyRepository intermediateResultsCounterpartyRepository;

    @Transactional(readOnly = true)
    public IntermediateResultsCounterparty findIntermediateResultsCounterpartyWithId(int id) {
        return intermediateResultsCounterpartyRepository.findOne(id);
    }

}
