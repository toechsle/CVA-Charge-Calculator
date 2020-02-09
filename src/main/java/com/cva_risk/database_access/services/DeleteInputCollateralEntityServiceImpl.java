package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputCollateralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DeleteInputCollateralEntityServiceImpl implements DeleteInputCollateralEntityService {

    @Autowired
    private InputCollateralRepository inputCollateralRepository;

    @Transactional
    public void execute() {
        inputCollateralRepository.deleteAll();
    }

}
