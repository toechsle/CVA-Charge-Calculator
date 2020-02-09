package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.FinalResultRepository;
import com.cva_risk.model.FinalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AddFinalResultServiceImpl implements AddFinalResultService {

    @Autowired
    private FinalResultRepository finalResultRepository;

    @Transactional
    public void saveFinalResult(FinalResult finalResultDAO) {

        FinalResult finalResult = new FinalResult();

        finalResult.setId(finalResultDAO.getId());
        finalResult.setValue(finalResultDAO.getValue());

        finalResultRepository.save(finalResult);

    }

}
