package com.cva_risk.ui.intermediate_results_views;


import com.cva_risk.ui.commons.GUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@SpringView(name= IntermediateResultsTransactionsView.NAME, ui= GUI.class)
public class IntermediateResultsTransactionsView extends VerticalLayout implements View {

    public static final String NAME = "IntermediateResultsTransactions";

    @Autowired
    IntermediateResultsTransactionsGrid intermediateResultsTransactionsGrid;


    @PostConstruct
    void init() {
        setMargin(false);
        addComponent(intermediateResultsTransactionsGrid);
        intermediateResultsTransactionsGrid.setSizeFull();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

}
