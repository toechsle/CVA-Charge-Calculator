package com.cva_risk.database_access.services;

import com.cva_risk.model.InputTransaction;

import java.util.List;

public interface GetInputTransactionAllService {

    List<InputTransaction> findAllInputTransactions();

}
