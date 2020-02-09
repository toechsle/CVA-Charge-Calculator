package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.IntermediateResultsTransactionRepository;
import com.cva_risk.model.IntermediateResultsTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GetIntermediateResultsTransactionInNSServiceImpl implements GetIntermediateResultsTransactionInNSService {

    @Autowired
    private IntermediateResultsTransactionRepository intermediateResultsTransactionRepository;

    @Transactional(readOnly = true)
    public List<IntermediateResultsTransaction> find(int nettingSetId) {
        return intermediateResultsTransactionRepository.findTransactionsInNSWithId(nettingSetId);
    }
}
