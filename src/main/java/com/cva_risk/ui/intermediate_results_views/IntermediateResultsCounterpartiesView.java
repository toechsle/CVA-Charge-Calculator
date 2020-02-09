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
@SpringView(name= IntermediateResultsCounterpartiesView.NAME, ui= GUI.class)
public class IntermediateResultsCounterpartiesView extends VerticalLayout implements View {

    public static final String NAME = "IntermediateResultsCounterparties";

    @Autowired
    private IntermediateResultsCounterpartiesGrid intermediateResultsCounterpartiesGrid;


    @PostConstruct
    void init() {
        setMargin(false);
        addComponent(intermediateResultsCounterpartiesGrid);
        intermediateResultsCounterpartiesGrid.setSizeFull();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
