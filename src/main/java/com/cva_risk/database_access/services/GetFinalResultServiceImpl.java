package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.FinalResultRepository;
import com.cva_risk.model.FinalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GetFinalResultServiceImpl implements GetFinalResultService {

    @Autowired
    private FinalResultRepository finalResultRepository;

    @Transactional(readOnly = true)
    public FinalResult retrieveValue() {
        FinalResult finalResult = finalResultRepository.findOne(1);
        return finalResult;
    }

}
