package com.cva_risk.database_access.services;

import com.cva_risk.model.InputCollateral;

import java.util.List;

public interface GetInputCollateralAllService {

    List<InputCollateral> findAllInputCollateral();
}
