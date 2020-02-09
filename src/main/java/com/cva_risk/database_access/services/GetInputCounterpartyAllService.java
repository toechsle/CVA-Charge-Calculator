package com.cva_risk.database_access.services;

import com.cva_risk.model.InputCounterparty;

import java.util.List;

public interface GetInputCounterpartyAllService {

    List<InputCounterparty> findAllInputCounterparties();
}
