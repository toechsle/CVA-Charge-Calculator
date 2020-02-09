package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputTransactionRepository;
import com.cva_risk.model.InputTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GetInputTransactionAllServiceImpl implements GetInputTransactionAllService {

    @Autowired
    private InputTransactionRepository inputTransactionRepository;

    @Transactional(readOnly = true)
    public List<InputTransaction> findAllInputTransactions() {
        return inputTransactionRepository.findAll();
    }

}
