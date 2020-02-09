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
@SpringView(name= InputCounterpartiesView.NAME, ui= GUI.class)
public class InputCounterpartiesView extends VerticalLayout implements View {

    public static final String NAME = "InputCounterparties";

    @Autowired
    private InputCounterpartiesGrid inputCounterpartiesGrid;

    @PostConstruct
    void init() {
        setMargin(false);
        addComponent(inputCounterpartiesGrid);
        inputCounterpartiesGrid.setSizeFull();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

}
