package com.cva_risk.database_access.services;

import com.cva_risk.model.IntermediateResultsCounterparty;

import java.util.List;

public interface GetIntermediateResultsNettingSetEADOfNettingSetsWithCounterpartyService {

    List<Double> find(IntermediateResultsCounterparty intermediateResultsCounterparty);
}
