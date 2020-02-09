package com.cva_risk.database_access.services;

import com.cva_risk.database_access.repositories.InputCollateralRepository;
import com.cva_risk.model.InputCollateral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AddInputCollateralServiceImpl implements AddInputCollateralService {

    @Autowired
    private InputCollateralRepository inputCollateralRepository;

    @Transactional
    public void saveInputCollateral(InputCollateral inputCollateralDAO) {

        InputCollateral inputCollateral = new InputCollateral();

        inputCollateral.setId(inputCollateralDAO.getId());
        inputCollateral.setNetCollateralReceived(inputCollateralDAO.getNetCollateralReceived());

        inputCollateralRepository.save(inputCollateral);

    }

}
