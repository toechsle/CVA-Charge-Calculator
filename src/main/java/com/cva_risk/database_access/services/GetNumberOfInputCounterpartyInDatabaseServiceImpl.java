package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputCounterpartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GetNumberOfInputCounterpartyInDatabaseServiceImpl implements GetNumberOfInputCounterpartyInDatabaseService {

    @Autowired
    private InputCounterpartyRepository inputCounterpartyRepository;

    @Transactional(readOnly = true)
    public int countInputCounterpartyInDatabase() {
        return (int) inputCounterpartyRepository.count();
    }
}
