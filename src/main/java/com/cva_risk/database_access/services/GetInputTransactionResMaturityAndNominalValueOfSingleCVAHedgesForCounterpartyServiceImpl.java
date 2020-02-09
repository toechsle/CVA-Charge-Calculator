package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GetInputTransactionResMaturityAndNominalValueOfSingleCVAHedgesForCounterpartyServiceImpl implements GetInputTransactionResMaturityAndNominalValueOfSingleCVAHedgesForCounterpartyService{

    @Autowired
    private InputTransactionRepository inputTransactionRepository;

    @Transactional(readOnly = true)
    public List<Object[]> find(Integer idOfReferencedCounterparty) {
        return inputTransactionRepository.findResMaturityAndNominalValueOfSingleCVAHedgesForCounterparty(idOfReferencedCounterparty);
    }

}
