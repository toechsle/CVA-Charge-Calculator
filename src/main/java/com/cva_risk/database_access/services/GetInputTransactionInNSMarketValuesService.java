package com.cva_risk.database_access.services;

import java.util.List;

public interface GetInputTransactionInNSMarketValuesService {

    List<Double> find(int nettingSetId);
}
