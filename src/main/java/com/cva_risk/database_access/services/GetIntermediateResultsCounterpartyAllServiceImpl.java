package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsCounterpartyRepository;
import com.cva_risk.model.IntermediateResultsCounterparty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GetIntermediateResultsCounterpartyAllServiceImpl implements GetIntermediateResultsCounterpartyAllService {

    @Autowired
    private IntermediateResultsCounterpartyRepository intermediateResultsCounterpartyRepository;

    @Transactional(readOnly = true)
    public List<IntermediateResultsCounterparty> findAllIntermediateResultsCounterparties() {
        return intermediateResultsCounterpartyRepository.findAll();
    }

}
