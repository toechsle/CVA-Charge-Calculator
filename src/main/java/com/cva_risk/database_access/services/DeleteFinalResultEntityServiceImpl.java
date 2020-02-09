package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.FinalResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DeleteFinalResultEntityServiceImpl implements DeleteFinalResultEntityService {

    @Autowired
    private FinalResultRepository finalResultRepository;

    @Transactional
    public void execute() {
        finalResultRepository.deleteAll();
    }

}
