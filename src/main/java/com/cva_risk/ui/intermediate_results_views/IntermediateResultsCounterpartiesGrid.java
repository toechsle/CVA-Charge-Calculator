package com.cva_risk.ui.intermediate_results_views;

import com.cva_risk.database_access.services.GetIntermediateResultsCounterpartyAllServiceImpl;
import com.cva_risk.database_access.services.GetNumberOfIntermediateResultsCounterpartyInDatabaseServiceImpl;
import com.cva_risk.model.IntermediateResultsCounterparty;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@SpringComponent
public class IntermediateResultsCounterpartiesGrid extends Grid<IntermediateResultsCounterparty> {

    @Autowired
    private GetIntermediateResultsCounterpartyAllServiceImpl getIntermediateResultsCounterpartyAllService;

    @Autowired
    private GetNumberOfIntermediateResultsCounterpartyInDatabaseServiceImpl getNumberOfIntermediateResultsCounterpartyInDatabaseService;


    @PostConstruct
    void init() {

        setDataProvider(
                (sortOrders, offset, limit) -> getIntermediateResultsCounterpartyAllService.findAllIntermediateResultsCounterparties().stream(),
                () -> getNumberOfIntermediateResultsCounterpartyInDatabaseService.countIntermediateResultsCounterpartyInDatabase()
        );


        addColumn(IntermediateResultsCounterparty::getId).setCaption("Id");
        addColumn(IntermediateResultsCounterparty::getName).setCaption("Name");

        addColumn(IntermediateResultsCounterparty::getEadDiscounted).setCaption("Discounted EAD");
        addColumn(IntermediateResultsCounterparty::getEad).setCaption("EAD");
        addColumn(IntermediateResultsCounterparty::getEffectiveResidualMaturity).setCaption("M");

        addColumn(IntermediateResultsCounterparty::getmHedgeTimesB).setCaption("M(hedge) x B");

        addColumn(IntermediateResultsCounterparty::getWeight).setCaption("Weight (%)");
        addColumn(IntermediateResultsCounterparty::getWeightRatingCRAG).setCaption("Weight (%) impl. by CRAG Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingDBRS).setCaption("Weight (%) impl. by DBRS Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingEHRG).setCaption("Weight (%) impl. by EHRG Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingFitch).setCaption("Weight (%) impl. by Fitch Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingJCRA).setCaption("Weight (%) impl. by JCRA Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingMoodys).setCaption("Weight (%)impl. by Moodys Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingSandP).setCaption("Weight (%) impl. by S&P Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingDBRSShortTerm).setCaption("Weight (%) impl. by DBRS Short-Term Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingFitchShortTerm).setCaption("Weight (%) impl. by Fitch Short-Term Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingJCRAShortTerm).setCaption("Weight (%) impl. by JCRA Short-Term Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingMoodysShortTerm).setCaption("Weight (%) impl. by Moody's Short-Term Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingSandPShortTerm).setCaption("Weight (%) impl. by S&P Short-Term Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingFitchCIU).setCaption("Weight (%) impl. by Fitch CIU-Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingMoodysCIU).setCaption("Weight (%) impl. by Moody's CIU-Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingSandPFundCreditQualityRatingsCIU).setCaption("Weight (%) impl. by S&P Fund Credit Quality CIU-Rating");
        addColumn(IntermediateResultsCounterparty::getWeightRatingSandPPrincipalStabilityFundRatingsCIU).setCaption("Weight (%) impl. by S&P Principal Stability Fund CIU-Rating");

    }

}
