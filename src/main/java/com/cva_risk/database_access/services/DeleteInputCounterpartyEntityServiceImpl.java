package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputCounterpartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DeleteInputCounterpartyEntityServiceImpl implements DeleteInputCounterpartyEntityService {

    @Autowired
    private InputCounterpartyRepository inputCounterpartyRepository;

    @Transactional
    public void execute() {
        inputCounterpartyRepository.deleteAll();
    }

}
