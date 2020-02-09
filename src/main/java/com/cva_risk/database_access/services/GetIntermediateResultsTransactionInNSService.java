package com.cva_risk.database_access.services;

import com.cva_risk.model.IntermediateResultsTransaction;

import java.util.List;

public interface GetIntermediateResultsTransactionInNSService {

    List<IntermediateResultsTransaction> find(int nettingSetId);
}
