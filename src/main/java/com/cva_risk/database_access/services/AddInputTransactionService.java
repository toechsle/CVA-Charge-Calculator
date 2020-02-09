package com.cva_risk.database_access.services;

import com.cva_risk.model.InputTransaction;

public interface AddInputTransactionService {

    void saveInputTransaction(InputTransaction inputTransactionDAO);

}
