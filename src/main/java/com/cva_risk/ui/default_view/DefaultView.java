package com.cva_risk.ui.default_view;

import com.cva_risk.business_logic.*;
import com.cva_risk.database_access.services.*;
import com.cva_risk.ui.commons.GUI;
import com.cva_risk.utils.Flags;
import com.cva_risk.utils.Global;
import com.cva_risk.utils.ReadXmlDataIntoDatabase;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


@UIScope
@SpringView(name=DefaultView.NAME, ui= GUI.class)
public class DefaultView extends VerticalLayout implements View {

    public static final String NAME = "";

    @Autowired
    private ReadXmlDataIntoDatabase readXmlDataIntoDatabase;
    @Autowired
    private CalculateIntermediateResultsCounterparty calculateIntermediateResultsCounterparty;
    @Autowired
    private CalculateIntermediateResultsTransaction calculateIntermediateResultsTransaction;
    @Autowired
    private CalculateIntermediateResultsNettingSet calculateIntermediateResultsNettingSet;
    @Autowired
    private CalculateIntermediateResultsCounterparty2 calculateIntermediateResultsCounterparty2;
    @Autowired
    private CalculateFinalResult calculateFinalResult;
    @Autowired
    private DeleteInputCounterpartyEntityServiceImpl deleteInputCounterpartyEntityService;
    @Autowired
    private DeleteInputTransactionEntityServiceImpl deleteInputTransactionEntityService;
    @Autowired
    private DeleteInputCollateralEntityServiceImpl deleteInputCollateralEntityService;
    @Autowired
    private DeleteIntermediateResultsCounterpartyEntityServiceImpl deleteIntermediateResultsCounterpartyEntityService;
    @Autowired
    private DeleteIntermediateResultsTransactionEntityServiceImpl deleteIntermediateResultsTransactionEntityService;
    @Autowired
    private DeleteIntermediateResultsNettingSetEntityServiceImpl deleteIntermediateResultsNettingSetEntityService;
    @Autowired
    private DeleteFinalResultEntityServiceImpl deleteFinalResultEntityService;

    private GridLayout gridLayout;
    private Image imageForUploader;
    private Label labelFilename;
    private Label labelSuccessForUploader;
    private Upload upload;
    private Image imageForXMLReader;
    private Label labelSuccessForXMLReader;
    private Button parseXMLDataButton;
    private Image imageForCalculationPanel;
    private Label labelSuccessCalculationPanel;
    private Button calculateButton;
    private Label labelPlaceholder;
    private Button eraseDataButton;


    @PostConstruct
    void init() {

        gridLayout = new GridLayout(7,3);
        gridLayout.setSizeFull();
        addComponent(gridLayout);

        setDefaultValuesForFlags();
        createArrows();
        createFileUploader();
        createXMLReader();
        createFlagSettingPanel();
        createCalculationPanel();
        createPlaceholderRow();
        createDataEraser();

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    private void setDefaultValuesForFlags() {
        Flags.HEDGING = true;
        Flags.BAIS = false;
    }

    private void createArrows() {

        ThemeResource iconFile = new ThemeResource("images/arrowIcon64.png");

        Image imageForArrows1 = new Image();
        imageForArrows1.setSource(iconFile);

        Image imageForArrows2 = new Image();
        imageForArrows2.setSource(iconFile);

        Image imageForArrows3 = new Image();
        imageForArrows3.setSource(iconFile);

        gridLayout.addComponent(imageForArrows1, 1, 0 );
        gridLayout.setComponentAlignment(imageForArrows1, Alignment.TOP_CENTER);

        gridLayout.addComponent(imageForArrows2, 3, 0 );
        gridLayout.setComponentAlignment(imageForArrows2, Alignment.TOP_CENTER);

        gridLayout.addComponent(imageForArrows3, 5, 0 );
        gridLayout.setComponentAlignment(imageForArrows3, Alignment.TOP_CENTER);

    }

    private void createFileUploader() {

        imageForUploader = new Image("");
        imageForUploader.setVisible(false);

        labelFilename = new Label();
        labelFilename.setVisible(false);
        labelFilename.addStyleName("whiteText");

        labelSuccessForUploader = new Label("Upload successful");
        labelSuccessForUploader.setVisible(false);
        labelFilename.addStyleName("whiteText");


        class FileReceiver implements Upload.Receiver, Upload.SucceededListener {

            private File file;
            private ThemeResource iconFile;

            public OutputStream receiveUpload(String filename, String mimeType) {
                Global.NAME_OF_INPUT_DATA_FILE = filename;
                FileOutputStream fileOutputStream;
                try {
                    file = new File("/tmp/" + filename);
                    fileOutputStream = new FileOutputStream(file);
                    labelFilename.setCaption(filename);
                }
                catch (final java.io.FileNotFoundException e) {
                    new Notification("Could not open file",
                            e.getMessage(),
                            Notification.Type.ERROR_MESSAGE)
                            .show(Page.getCurrent());
                    return null;
                }
                return fileOutputStream;
            }

            public void uploadSucceeded(Upload.SucceededEvent event) {
                iconFile = new ThemeResource("images/fileUploadIcon64.png");
                imageForUploader.setVisible(true);
                imageForUploader.setSource(iconFile);
                labelFilename.setVisible(true);
                labelSuccessForUploader.setVisible(true);
            }

        };

        FileReceiver receiver = new FileReceiver();

        upload = new Upload("", receiver);
        upload.setButtonCaption("Start Upload");
        upload.addSucceededListener(receiver);

        Panel panel = new Panel("<center>Data Upload</center>");
        VerticalLayout panelContent = new VerticalLayout();
        panelContent.setSizeFull();
        panelContent.setMargin(true);
        panelContent.addComponents(upload, labelSuccessForUploader, imageForUploader, labelFilename);
        panelContent.setComponentAlignment(upload, Alignment.TOP_CENTER);
        panelContent.setComponentAlignment(labelSuccessForUploader, Alignment.TOP_CENTER);
        panelContent.setComponentAlignment(imageForUploader, Alignment.TOP_LEFT);
        panelContent.setComponentAlignment(labelFilename, Alignment.TOP_LEFT);
        panel.setContent(panelContent);

        ((VerticalLayout) panel.getContent()).setSpacing(true);
        panel.setWidth("-1");
        gridLayout.addComponent(panel, 0, 0);
        gridLayout.setComponentAlignment(panel, Alignment.TOP_LEFT);

    }

    private void createXMLReader() {

        imageForXMLReader = new Image("");
        imageForXMLReader.setVisible(false);

        labelSuccessForXMLReader = new Label("Import successful");
        labelSuccessForXMLReader.setVisible(false);

        parseXMLDataButton = new Button("Start Import");
        parseXMLDataButton.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                try {
                    readXmlDataIntoDatabase.execute();
                    ThemeResource iconFile = new ThemeResource("images/successIcon64.png");
                    imageForXMLReader.setVisible(true);
                    imageForXMLReader.setSource(iconFile);
                    labelSuccessForXMLReader.setVisible(true);
                }
                catch (Exception e) {
                    new Notification("Could not import data",
                            e.getMessage(),
                            Notification.Type.ERROR_MESSAGE)
                            .show(Page.getCurrent());
                }
            }
        });

        Panel panel = new Panel("<center>Data Import</center>");
        VerticalLayout panelContent = new VerticalLayout();
        panelContent.setSizeFull();
        panelContent.setMargin(true);
        panelContent.addComponents(parseXMLDataButton, labelSuccessForXMLReader, imageForXMLReader);
        panelContent.setComponentAlignment(parseXMLDataButton, Alignment.TOP_CENTER);
        panelContent.setComponentAlignment(labelSuccessForXMLReader, Alignment.TOP_CENTER);
        panelContent.setComponentAlignment(imageForXMLReader, Alignment.TOP_CENTER);
        panel.setContent(panelContent);

        ((VerticalLayout) panel.getContent()).setSpacing(true);
        panel.setWidth("-1");
        gridLayout.addComponent(panel, 2, 0 );
        gridLayout.setComponentAlignment(panel, Alignment.TOP_CENTER);

    }

    private void createFlagSettingPanel() {

        RadioButtonGroup<String> choiceHedging = new RadioButtonGroup<>("Take into account CVA-Hedges?");
        String choice1Hedging = "Yes (default)";
        String choice2Hedging = "No";
        choiceHedging.setItems(choice1Hedging, choice2Hedging);
        choiceHedging.setSelectedItem(choice1Hedging);

        choiceHedging.addSelectionListener(singleSelectionEvent -> {
                String selection = singleSelectionEvent.getSelectedItem().orElse("none");
                if (selection.equals(choice2Hedging)) {
                    Flags.HEDGING = false;
                }
                else {
                    Flags.HEDGING = true;
                }
        });

        RadioButtonGroup<String> choiceMethod = new RadioButtonGroup<>("Select calculation method");
        String choice1Method = "ABACUS (default)";
        String choice2Method = "BAIS";
        choiceMethod.setItems(choice1Method, choice2Method);
        choiceMethod.setSelectedItem(choice1Method);

        choiceMethod.addSelectionListener(singleSelectionEvent -> {
            String selection = singleSelectionEvent.getSelectedItem().orElse("none");
            if (selection.equals(choice2Method)) {
                Flags.BAIS = true;
            }
            else {
                Flags.BAIS = false;
            }
        });

        Label placeholder = new Label("");

        Panel panel = new Panel("<center>Flag Setting</center>");
        VerticalLayout panelContent = new VerticalLayout();
        panelContent.setSizeFull();
        panelContent.setMargin(true);
        panelContent.addComponents(choiceHedging, placeholder, choiceMethod);
        panel.setContent(panelContent);

        ((VerticalLayout) panel.getContent()).setSpacing(true);
        panel.setWidth("-1");
        gridLayout.addComponent(panel, 4, 0 );
        gridLayout.setComponentAlignment(panel, Alignment.TOP_CENTER);

    }

    private void createCalculationPanel() {

        imageForCalculationPanel = new Image("");
        imageForCalculationPanel.setVisible(false);

        labelSuccessCalculationPanel = new Label("Calculation finished");
        labelSuccessCalculationPanel.setVisible(false);

        calculateButton = new Button("Start Calculation");
        calculateButton.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                calculateCVACharge();
                ThemeResource iconFile = new ThemeResource("images/successIcon64.png");
                imageForCalculationPanel.setVisible(true);
                imageForCalculationPanel.setSource(iconFile);
                labelSuccessCalculationPanel.setVisible(true);
            }
        });

        Panel panel = new Panel("<center>Calculation</center>");
        VerticalLayout panelContent = new VerticalLayout();
        panelContent.setSizeFull();
        panelContent.setMargin(true);

        panelContent.addComponents(calculateButton, labelSuccessCalculationPanel, imageForCalculationPanel);
        panelContent.setComponentAlignment(calculateButton, Alignment.TOP_CENTER);
        panelContent.setComponentAlignment(labelSuccessCalculationPanel, Alignment.TOP_CENTER);
        panelContent.setComponentAlignment(imageForCalculationPanel, Alignment.TOP_CENTER);
        panel.setContent(panelContent);

        ((VerticalLayout) panel.getContent()).setSpacing(true);
        panel.setWidth("-1");
        gridLayout.addComponent(panel, 6, 0 );
        gridLayout.setComponentAlignment(panel, Alignment.TOP_CENTER);

    }

    private void calculateCVACharge() {

        calculateIntermediateResultsCounterparty.execute();
        calculateIntermediateResultsTransaction.execute();
        calculateIntermediateResultsNettingSet.execute();
        calculateIntermediateResultsCounterparty2.execute();
        calculateFinalResult.execute();

    }

    private void createPlaceholderRow() {

        labelPlaceholder = new Label("");

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.setMargin(true);
        verticalLayout.addComponent(labelPlaceholder);
        verticalLayout.setComponentAlignment(labelPlaceholder, Alignment.TOP_CENTER);

        gridLayout.addComponent(verticalLayout, 0, 1, 6, 1 );
        gridLayout.setComponentAlignment(verticalLayout, Alignment.TOP_CENTER);

    }

    private void createDataEraser() {

        eraseDataButton = new Button("Remove Data");
        eraseDataButton.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                try {
                    deleteAllEntities();
                    Page.getCurrent().reload();
                }
                catch (Exception e) {
                    new Notification("Could not perform request",
                            e.getMessage(),
                            Notification.Type.HUMANIZED_MESSAGE)
                            .show(Page.getCurrent());
                }
            }
        });

        Panel panel = new Panel("<center>Old Data Removal</center>");
        VerticalLayout panelContent = new VerticalLayout();
        panelContent.setSizeFull();
        panelContent.setMargin(true);
        panelContent.addComponent(eraseDataButton);
        panelContent.setComponentAlignment(eraseDataButton, Alignment.TOP_CENTER);
        panel.setContent(panelContent);

        ((VerticalLayout) panel.getContent()).setSpacing(true);
        panel.setSizeFull();
        gridLayout.addComponent(panel, 0, 2, 6, 2 );
        gridLayout.setComponentAlignment(panel, Alignment.BOTTOM_CENTER);

    }

    private void deleteAllEntities() {

        deleteInputCounterpartyEntityService.execute();
        deleteInputTransactionEntityService.execute();
        deleteInputCollateralEntityService.execute();
        deleteIntermediateResultsCounterpartyEntityService.execute();
        deleteIntermediateResultsTransactionEntityService.execute();
        deleteIntermediateResultsNettingSetEntityService.execute();
        deleteFinalResultEntityService.execute();

    }


}
