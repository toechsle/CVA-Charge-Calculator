package com.cva_risk.ui.result_view;

import com.cva_risk.database_access.services.GetFinalResultServiceImpl;
import com.cva_risk.model.FinalResult;
import com.cva_risk.ui.commons.GUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.math.RoundingMode;
import java.text.DecimalFormat;


@UIScope
@SpringView(name= ResultView.NAME, ui= GUI.class)
public class ResultView extends VerticalLayout implements View {

    public static final String NAME = "Result";

    @Autowired
    private GetFinalResultServiceImpl getFinalResultService;
    private FinalResult finalResult;
    private Label labelResult;
    private Double cvaCharge;
    private DecimalFormat decimalFormat;
    private String cvaChargeRounded;
    private Label labelPlaceholder1;
    private Label labelPlaceholder2;


    @PostConstruct
    void init() {

        labelPlaceholder1 = new Label("");
        addComponent(labelPlaceholder1);
        setComponentAlignment(labelPlaceholder1, Alignment.BOTTOM_CENTER);

        labelPlaceholder2 = new Label("");
        addComponent(labelPlaceholder2);
        setComponentAlignment(labelPlaceholder2, Alignment.BOTTOM_CENTER);

        labelResult = new Label();
        addComponent(labelResult);
        setComponentAlignment(labelResult, Alignment.BOTTOM_CENTER);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

        try {
            finalResult = getFinalResultService.retrieveValue();
            cvaCharge = finalResult.getValue();
            decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            cvaChargeRounded = decimalFormat.format(cvaCharge);
            labelResult.setValue("CVA-Charge: " + cvaChargeRounded);
        }
        catch (Exception e) {
            new Notification("There is no result to show",
                    e.getMessage(),
                    Notification.Type.HUMANIZED_MESSAGE)
                    .show(Page.getCurrent());
        }

    }

}
