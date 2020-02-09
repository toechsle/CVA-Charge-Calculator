package com.cva_risk.database_access.services;

import com.cva_risk.model.IntermediateResultsTransaction;

public interface AddIntermediateResultsTransactionService {

    void saveIntermediateResultsTransaction(IntermediateResultsTransaction intermediateResultsTransactionDAO);
}
