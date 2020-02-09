package com.cva_risk.database_access.services;

import java.util.List;

public interface GetInputTransactionResMaturityAndNominalValueOfSingleCVAHedgesForCounterpartyService {

    List<Object[]> find(Integer idOfReferencedCounterparty);

}
