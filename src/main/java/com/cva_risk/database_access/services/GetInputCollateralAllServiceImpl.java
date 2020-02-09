package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputCollateralRepository;
import com.cva_risk.model.InputCollateral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GetInputCollateralAllServiceImpl implements GetInputCollateralAllService {

    @Autowired
    private InputCollateralRepository inputCollateralRepository;

    @Transactional(readOnly = true)
    public List<InputCollateral> findAllInputCollateral() {
        return inputCollateralRepository.findAll();
    }

}
