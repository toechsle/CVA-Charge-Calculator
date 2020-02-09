package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputCollateralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GetNumberOfInputCollateralInDatabaseServiceImpl implements GetNumberOfInputCollateralInDatabaseService {

    @Autowired
    private InputCollateralRepository inputCollateralRepository;

    @Transactional(readOnly = true)
    public int countInputCollateralInDatabase() {
        return (int) inputCollateralRepository.count();
    }
}
