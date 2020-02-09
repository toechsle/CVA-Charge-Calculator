package com.cva_risk.ui.intermediate_results_views;

import com.cva_risk.database_access.services.GetIntermediateResultsNettingSetAllServiceImpl;
import com.cva_risk.database_access.services.GetNumberOfIntermediateResultsNettingSetInDatabaseServiceImpl;
import com.cva_risk.model.IntermediateResultsNettingSet;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


@UIScope
@SpringComponent
public class IntermediateResultsNettingSetsGrid extends Grid<IntermediateResultsNettingSet> {

    @Autowired
    private GetIntermediateResultsNettingSetAllServiceImpl getIntermediateResultsNettingSetAllService;

    @Autowired
    private GetNumberOfIntermediateResultsNettingSetInDatabaseServiceImpl getNumberOfIntermediateResultsNettingSetInDatabaseService;


    @PostConstruct
    void init() {

        setDataProvider(
                (sortOrders, offset, limit) -> getIntermediateResultsNettingSetAllService.findAllIntermediateResultsNettingSets().stream(),
                () -> getNumberOfIntermediateResultsNettingSetInDatabaseService.countIntermediateResultsNettingSetInDatabase()
        );

        addColumn(IntermediateResultsNettingSet::getId).setCaption("Id");
        addColumn(IntermediateResultsNettingSet::getIntermediateResultsCounterpartyId).setCaption("Counterparty Id");

        addColumn(IntermediateResultsNettingSet::getDiscountedExposureValueAfterCollateral).setCaption("Discounted Exposure Value after Collateral");

        addColumn(IntermediateResultsNettingSet::getExposureValueAfterCollateral).setCaption("Exposure Value after Collateral");
        addColumn(IntermediateResultsNettingSet::getExposureValueBeforeCollateral).setCaption("Exposure Value before Collateral");

        addColumn(IntermediateResultsNettingSet::getEffectiveResidualMaturity).setCaption("Effective Residual Maturity (Years)");

        addColumn(IntermediateResultsNettingSet::getResidualMaturity).setCaption("Residual Maturity (Years)");
        addColumn(IntermediateResultsNettingSet::getNominalValue).setCaption("Nominal Value");
        addColumn(IntermediateResultsNettingSet::getNetReplacementCost).setCaption("Net Replacement Cost");
        addColumn(IntermediateResultsNettingSet::getGrossReplacementCost).setCaption("Gross Replacement Cost");
        addColumn(IntermediateResultsNettingSet::getNetToGrossRatio).setCaption("Net to Gross Ratio");
        addColumn(IntermediateResultsNettingSet::getPceGross).setCaption("PCE gross");
        addColumn(IntermediateResultsNettingSet::getPceRed).setCaption("PCE reduced");

    }

}
