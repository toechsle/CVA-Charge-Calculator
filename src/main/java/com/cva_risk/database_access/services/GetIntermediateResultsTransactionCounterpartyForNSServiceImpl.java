package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsTransactionRepository;
import com.cva_risk.model.IntermediateResultsCounterparty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GetIntermediateResultsTransactionCounterpartyForNSServiceImpl implements GetIntermediateResultsTransactionCounterpartyForNSService {

    @Autowired
    private IntermediateResultsTransactionRepository intermediateResultsTransactionRepository;

    @Transactional(readOnly = true)
    public IntermediateResultsCounterparty findIntermediateResultsCounterpartyForNSWithId(Integer nettingSetId) {
        return intermediateResultsTransactionRepository.findCounterpartyForNSWithId(nettingSetId);
    }

}
