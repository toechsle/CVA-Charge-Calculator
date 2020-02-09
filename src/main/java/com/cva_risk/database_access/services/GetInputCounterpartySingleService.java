package com.cva_risk.database_access.services;

import com.cva_risk.model.InputCounterparty;


public interface GetInputCounterpartySingleService {

    InputCounterparty findInputCounterpartyWithId(Integer id);
}
