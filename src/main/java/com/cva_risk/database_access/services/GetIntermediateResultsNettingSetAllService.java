package com.cva_risk.database_access.services;

import com.cva_risk.model.IntermediateResultsNettingSet;

import java.util.List;

public interface GetIntermediateResultsNettingSetAllService {

    List<IntermediateResultsNettingSet> findAllIntermediateResultsNettingSets();
}
