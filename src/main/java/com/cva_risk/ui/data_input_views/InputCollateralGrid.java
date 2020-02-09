package com.cva_risk.ui.data_input_views;

import com.cva_risk.database_access.services.GetInputCollateralAllServiceImpl;
import com.cva_risk.database_access.services.GetNumberOfInputCollateralInDatabaseServiceImpl;
import com.cva_risk.model.InputCollateral;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@SpringComponent
public class InputCollateralGrid extends Grid<InputCollateral> {

    @Autowired
    private GetInputCollateralAllServiceImpl getInputCollateralAllService;

    @Autowired
    private GetNumberOfInputCollateralInDatabaseServiceImpl getNumberOfInputCollateralInDatabaseService;


    @PostConstruct
    void init() {

        setDataProvider(
                (sortOrders, offset, limit) -> getInputCollateralAllService.findAllInputCollateral().stream(),
                () -> getNumberOfInputCollateralInDatabaseService.countInputCollateralInDatabase()
        );

        addColumn(InputCollateral::getId).setCaption("Id");
        addColumn(InputCollateral::getNetCollateralReceived).setCaption("Net Collateral Received");

    }

}
