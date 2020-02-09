package com.cva_risk.ui.commons;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Title("CVA Charge Calculator")
@Theme("mycustomtheme")
public class GUI extends UI {


    @Autowired
    private SpringViewProvider viewProvider;
    @Autowired
    private MenuBarFactory menuBarFactory;


    @Override
    protected void init(VaadinRequest request) {

        VerticalLayout rootLayout = new VerticalLayout();
        rootLayout.setSizeFull();
        setContent(rootLayout);


        MenuBar menuBar = menuBarFactory.createComponent();
		menuBar.setWidth(100, Unit.PERCENTAGE);
        rootLayout.addComponent(menuBar);

		Panel viewContainer = new Panel();
		viewContainer.setSizeFull();
		rootLayout.addComponent(viewContainer);
        rootLayout.setExpandRatio(viewContainer, 1.0f);


		Navigator navigator = new Navigator(this, viewContainer);
		navigator.addProvider(viewProvider);

    }

}