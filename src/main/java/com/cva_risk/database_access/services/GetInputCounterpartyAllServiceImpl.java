package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputCounterpartyRepository;
import com.cva_risk.model.InputCounterparty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GetInputCounterpartyAllServiceImpl implements GetInputCounterpartyAllService {

    @Autowired
    private InputCounterpartyRepository inputCounterpartyRepository;

    @Transactional(readOnly = true)
    public List<InputCounterparty> findAllInputCounterparties() {
        return inputCounterpartyRepository.findAll();
    }

}
