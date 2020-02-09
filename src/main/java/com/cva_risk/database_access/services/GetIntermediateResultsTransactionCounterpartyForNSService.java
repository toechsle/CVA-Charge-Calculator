package com.cva_risk.database_access.services;

import com.cva_risk.model.IntermediateResultsCounterparty;

public interface GetIntermediateResultsTransactionCounterpartyForNSService {

    IntermediateResultsCounterparty findIntermediateResultsCounterpartyForNSWithId(Integer nettingSetId);

}
