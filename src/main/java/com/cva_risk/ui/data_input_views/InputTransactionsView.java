package com.cva_risk.ui.data_input_views;

import com.cva_risk.ui.commons.GUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@SpringView(name= InputTransactionsView.NAME, ui= GUI.class)
public class InputTransactionsView extends VerticalLayout implements View {

    public static final String NAME = "InputTransactions";

    @Autowired
    private InputTransactionsGrid inputTransactionsGrid;

    @PostConstruct
    void init() {
        setMargin(false);
        addComponent(inputTransactionsGrid);
        inputTransactionsGrid.setSizeFull();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

}
