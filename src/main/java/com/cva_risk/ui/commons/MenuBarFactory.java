package com.cva_risk.ui.commons;

import com.cva_risk.ui.data_input_views.InputCollateralView;
import com.cva_risk.ui.data_input_views.InputCounterpartiesView;
import com.cva_risk.ui.data_input_views.InputTransactionsView;
import com.cva_risk.ui.default_view.DefaultView;
import com.cva_risk.ui.intermediate_results_views.IntermediateResultsCounterpartiesView;
import com.cva_risk.ui.intermediate_results_views.IntermediateResultsNettingSetsView;
import com.cva_risk.ui.intermediate_results_views.IntermediateResultsTransactionsView;
import com.cva_risk.ui.result_view.ResultView;
import com.vaadin.navigator.Navigator;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;


@UIScope
@SpringComponent
public class MenuBarFactory {

    private MenuBar menuBar = new MenuBar();

    private MenuBar.MenuItem menuItemDefaultView = menuBar.addItem("Start", null, new MenuBar.Command() {
        public void menuSelected(MenuBar.MenuItem selectedItem) {
            switchViewTo(DefaultView.NAME);
        }
    });
    private MenuBar.MenuItem menuItemDataInputView = menuBar.addItem("Data Input", null, null);
    private MenuBar.MenuItem menuItemIntermediateResultsView = menuBar.addItem("Intermediate Results", null, null);
    private MenuBar.MenuItem menuItemResultView = menuBar.addItem("Result", null, new MenuBar.Command() {
        public void menuSelected(MenuBar.MenuItem selectedItem) {
            switchViewTo(ResultView.NAME);
        }
    });

    private MenuBar.MenuItem menuItemInputCounterparties = menuItemDataInputView.addItem("Counterparties", null,  new MenuBar.Command() {
        public void menuSelected(MenuBar.MenuItem selectedItem) {
            switchViewTo(InputCounterpartiesView.NAME);
        }
    });
    private MenuBar.MenuItem menuItemInputTransactions = menuItemDataInputView.addItem("Transactions", null, new MenuBar.Command() {
        public void menuSelected(MenuBar.MenuItem selectedItem) {
            switchViewTo(InputTransactionsView.NAME);
        }
    });
    private MenuBar.MenuItem menuItemInputCollateral = menuItemDataInputView.addItem("Collateral", null, new MenuBar.Command() {
        public void menuSelected(MenuBar.MenuItem selectedItem) {
            switchViewTo(InputCollateralView.NAME);
        }
    });

    private MenuBar.MenuItem menuItemIntermediateResultsCounterparties = menuItemIntermediateResultsView.addItem("Counterparties", null,  new MenuBar.Command() {
        public void menuSelected(MenuBar.MenuItem selectedItem) {
            switchViewTo(IntermediateResultsCounterpartiesView.NAME);
        }
    });
    private MenuBar.MenuItem menuItemIntermediateResultsTransactions = menuItemIntermediateResultsView.addItem("Transactions", null, new MenuBar.Command() {
        public void menuSelected(MenuBar.MenuItem selectedItem) {
            switchViewTo(IntermediateResultsTransactionsView.NAME);
        }
    });
    private MenuBar.MenuItem menuItemIntermediateResultsNettingSets = menuItemIntermediateResultsView.addItem("Netting Sets", null, new MenuBar.Command() {
        public void menuSelected(MenuBar.MenuItem selectedItem) {
            switchViewTo(IntermediateResultsNettingSetsView.NAME);
        }
    });

    private void switchViewTo(String viewName) {
        Navigator navigator = UI.getCurrent().getNavigator();
        navigator.navigateTo(viewName);
    }

    public MenuBar createComponent() {
        return menuBar;
    }

}


