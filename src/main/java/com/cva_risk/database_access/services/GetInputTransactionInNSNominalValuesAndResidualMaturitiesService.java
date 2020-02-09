package com.cva_risk.database_access.services;

import java.util.List;

public interface GetInputTransactionInNSNominalValuesAndResidualMaturitiesService {

    List<Object[]> find(int nettingSetId);
}
