package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputCounterpartyRepository;
import com.cva_risk.model.InputCounterparty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GetInputCounterpartySingleServiceImpl implements GetInputCounterpartySingleService {

    @Autowired
    private InputCounterpartyRepository inputCounterpartyRepository;

    @Transactional(readOnly = true)
    public InputCounterparty findInputCounterpartyWithId(Integer id) {
        return inputCounterpartyRepository.findOne(id);
    }

}
