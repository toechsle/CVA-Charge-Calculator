package com.cva_risk.ui.intermediate_results_views;

import com.cva_risk.database_access.services.GetIntermediateResultsTransactionAllServiceImpl;
import com.cva_risk.database_access.services.GetNumberOfIntermediateResultsTransactionInDatabaseServiceImpl;
import com.cva_risk.model.IntermediateResultsTransaction;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


@UIScope
@SpringComponent
public class IntermediateResultsTransactionsGrid extends Grid<IntermediateResultsTransaction> {

    @Autowired
    private GetIntermediateResultsTransactionAllServiceImpl getIntermediateResultsTransactionAllService;

    @Autowired
    private GetNumberOfIntermediateResultsTransactionInDatabaseServiceImpl getNumberOfIntermediateResultsTransactionInDatabaseService;


    @PostConstruct
    void init() {

        setDataProvider(
                (sortOrders, offset, limit) -> getIntermediateResultsTransactionAllService.findAllIntermediateResultsTransactions().stream(),
                () -> getNumberOfIntermediateResultsTransactionInDatabaseService.countIntermediateResultsTransactionInDatabase()
        );

        addColumn(IntermediateResultsTransaction::getId).setCaption("Id");
        addColumn(IntermediateResultsTransaction::getIntermediateResultsCounterpartyId).setCaption("Counterparty Id");
        addColumn(IntermediateResultsTransaction::getVolatilityRate).setCaption("Volatility Rate (%)");
        addColumn(IntermediateResultsTransaction::getCurrentReplacementCost).setCaption("Current Replacement Cost");
        addColumn(IntermediateResultsTransaction::getAddOn).setCaption("Add-On");

    }
}
