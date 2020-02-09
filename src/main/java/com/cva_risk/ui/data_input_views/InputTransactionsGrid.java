package com.cva_risk.ui.data_input_views;

import com.cva_risk.database_access.services.GetInputTransactionAllServiceImpl;
import com.cva_risk.database_access.services.GetNumberOfInputTransactionInDatabaseServiceImpl;
import com.cva_risk.model.InputTransaction;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


@UIScope
@SpringComponent
public class InputTransactionsGrid extends Grid<InputTransaction> {

    @Autowired
    private GetInputTransactionAllServiceImpl getInputTransactionAllService;

    @Autowired
    private GetNumberOfInputTransactionInDatabaseServiceImpl getNumberOfInputTransactionInDatabaseService;


    @PostConstruct
    void init() {

        setDataProvider(
                (sortOrders, offset, limit) -> getInputTransactionAllService.findAllInputTransactions().stream(),
                () -> getNumberOfInputTransactionInDatabaseService.countInputTransactionInDatabase()
        );


        addColumn(InputTransaction::getId).setCaption("Id");
        addColumn(InputTransaction::getInputCounterpartyId).setCaption("Counterparty Id");
        addColumn(InputTransaction::getNettingSetId).setCaption("Netting Set Id");

        addColumn(InputTransaction::getCategory).setCaption("Category");
        addColumn(InputTransaction::getCurrentMarketValue).setCaption("Current Market Value");
        addColumn(InputTransaction::getNominalValue).setCaption("Nominal Value");
        addColumn(InputTransaction::getResidualMaturity).setCaption("Residual Maturity (Days)");

        addColumn(InputTransaction::getOptionWriterPosition).setCaption("Option Writer Position");
        addColumn(InputTransaction::getBasisSwap).setCaption("Basis Swap");
        addColumn(InputTransaction::getCvaHedge).setCaption("CVA Hedge");
        addColumn(InputTransaction::getReferencedCounterpartyId).setCaption("Referenced Counterparty Id");


    }
}
