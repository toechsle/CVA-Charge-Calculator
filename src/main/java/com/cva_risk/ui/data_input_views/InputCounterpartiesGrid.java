package com.cva_risk.ui.data_input_views;

import com.cva_risk.database_access.services.GetInputCounterpartyAllServiceImpl;
import com.cva_risk.database_access.services.GetNumberOfInputCounterpartyInDatabaseServiceImpl;
import com.cva_risk.model.InputCounterparty;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@SpringComponent
public class InputCounterpartiesGrid extends Grid<InputCounterparty> {

    @Autowired
    private GetInputCounterpartyAllServiceImpl getInputCounterpartyAllService;

    @Autowired
    private GetNumberOfInputCounterpartyInDatabaseServiceImpl getNumberOfInputCounterpartyInDatabaseService;


    @PostConstruct
    void init() {

        setDataProvider(
                (sortOrders, offset, limit) -> getInputCounterpartyAllService.findAllInputCounterparties().stream(),
                () -> getNumberOfInputCounterpartyInDatabaseService.countInputCounterpartyInDatabase()
        );


        addColumn(InputCounterparty::getId).setCaption("Id");
        addColumn(InputCounterparty::getName).setCaption("Name");

        addColumn(InputCounterparty::getRatingCRAG).setCaption("CRAG Rating");
        addColumn(InputCounterparty::getRatingDBRS).setCaption("DBRS Rating");
        addColumn(InputCounterparty::getRatingEHRG).setCaption("EHRG Rating");
        addColumn(InputCounterparty::getRatingFitch).setCaption("Fitch Rating");
        addColumn(InputCounterparty::getRatingJCRA).setCaption("JCRA Rating");
        addColumn(InputCounterparty::getRatingMoodys).setCaption("Moodys Rating");
        addColumn(InputCounterparty::getRatingSandP).setCaption("S&P Rating");

        addColumn(InputCounterparty::getRatingDBRSShortTerm).setCaption("DBRS Short-Term Rating");
        addColumn(InputCounterparty::getRatingFitchShortTerm).setCaption("Fitch Short-Term Rating");
        addColumn(InputCounterparty::getRatingJCRAShortTerm).setCaption("JCRA Short-Term Rating");
        addColumn(InputCounterparty::getRatingMoodysShortTerm).setCaption("Moody's Short-Term Rating");
        addColumn(InputCounterparty::getRatingSandPShortTerm).setCaption("S&P Short-Term Rating");

        addColumn(InputCounterparty::getRatingFitchCIU).setCaption("Fitch CIU-Rating");
        addColumn(InputCounterparty::getRatingMoodysCIU).setCaption("Moody's CIU-Rating");
        addColumn(InputCounterparty::getRatingSandPFundCreditQualityRatingsCIU).setCaption("S&P Fund Credit Quality CIU-Rating");
        addColumn(InputCounterparty::getRatingSandPPrincipalStabilityFundRatingsCIU).setCaption("S&P Principal Stability Fund CIU-Rating");

        addColumn(InputCounterparty::getArticle128).setCaption("Article 128");
        addColumn(InputCounterparty::getCreditQualityStepBasedOnIRBA).setCaption("Credit Quality Step based on IRBA");


    }

}
