package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GetInputTransactionResidualMaturityServiceImpl implements GetInputTransactionResidualMaturityService {

    @Autowired
    private InputTransactionRepository inputTransactionRepository;

    @Transactional(readOnly = true)
    public Integer find(int id) {
        return inputTransactionRepository.getResidualMaturityOfTransactionWithId(id);
    }

}
