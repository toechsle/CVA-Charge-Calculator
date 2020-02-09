package com.cva_risk.utils;

import com.cva_risk.database_access.services.AddInputCollateralServiceImpl;
import com.cva_risk.database_access.services.AddInputCounterpartyServiceImpl;
import com.cva_risk.database_access.services.AddInputTransactionServiceImpl;
import com.cva_risk.database_access.services.GetInputCounterpartySingleServiceImpl;
import com.cva_risk.model.InputCollateral;
import com.cva_risk.model.InputCounterparty;
import com.cva_risk.model.InputTransaction;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


@SpringComponent
public class SAXHandler extends DefaultHandler {

    @Autowired
    private AddInputCounterpartyServiceImpl addInputCounterpartyService;

    @Autowired
    private AddInputTransactionServiceImpl addInputTransactionService;

    @Autowired
    private AddInputCollateralServiceImpl addInputCollateralService;

    @Autowired
    private GetInputCounterpartySingleServiceImpl getInputCounterpartySingleService;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("Counterparty")) {

            InputCounterparty inputCounterparty = new InputCounterparty();

            int id = Integer.parseInt(attributes.getValue("id"));
            inputCounterparty.setId(id);

            if (attributes.getIndex("name") != -1) {
                String name = attributes.getValue("name");
                inputCounterparty.setName(name);
            }

            if (attributes.getIndex("creditQualityStepBasedOnIRBA") != -1) {
                Integer creditQualityStepBasedOnIRBA = Integer.valueOf(attributes.getValue("creditQualityStepBasedOnIRBA"));
                inputCounterparty.setCreditQualityStepBasedOnIRBA(creditQualityStepBasedOnIRBA);
            }

            if (attributes.getIndex("article128") != -1) {
                Boolean article128 = Boolean.valueOf(attributes.getValue("article128"));
                inputCounterparty.setArticle128(article128);
            }

            if (attributes.getIndex("ratingCRAG") != -1) {
                RatingsCRAG ratingCRAG = RatingsCRAG.fromString(attributes.getValue("ratingCRAG"));
                inputCounterparty.setRatingCRAG(ratingCRAG);
            }

            if (attributes.getIndex("ratingDBRS") != -1) {
                RatingsDBRS ratingDBRS = RatingsDBRS.fromString(attributes.getValue("ratingDBRS"));
                inputCounterparty.setRatingDBRS(ratingDBRS);
            }

            if (attributes.getIndex("ratingEHRG") != -1) {
                RatingsEHRG ratingEHRG = RatingsEHRG.fromString(attributes.getValue("ratingEHRG"));
                inputCounterparty.setRatingEHRG(ratingEHRG);
            }

            if (attributes.getIndex("ratingFitch") != -1) {
                RatingsFitch ratingFitch = RatingsFitch.fromString(attributes.getValue("ratingFitch"));
                inputCounterparty.setRatingFitch(ratingFitch);
            }

            if (attributes.getIndex("ratingJCRA") != -1) {
                RatingsJCRA ratingJCRA = RatingsJCRA.fromString(attributes.getValue("ratingJCRA"));
                inputCounterparty.setRatingJCRA(ratingJCRA);
            }

            if (attributes.getIndex("ratingMoodys") != -1) {
                RatingsMoodys ratingMoodys = RatingsMoodys.fromString(attributes.getValue("ratingMoodys"));
                inputCounterparty.setRatingMoodys(ratingMoodys);
            }

            if (attributes.getIndex("ratingSandP") != -1) {
                RatingsSandP ratingSandP = RatingsSandP.fromString(attributes.getValue("ratingSandP"));
                inputCounterparty.setRatingSandP(ratingSandP);
            }

            if (attributes.getIndex("ratingDBRSShortTerm") != -1) {
                RatingsDBRSShortTerm ratingDBRSShortTerm = RatingsDBRSShortTerm.fromString(attributes.getValue("ratingDBRSShortTerm"));
                inputCounterparty.setRatingDBRSShortTerm(ratingDBRSShortTerm);
            }

            if (attributes.getIndex("ratingFitchShortTerm") != -1) {
                RatingsFitchShortTerm ratingFitchShortTerm = RatingsFitchShortTerm.fromString(attributes.getValue("ratingFitchShortTerm"));
                inputCounterparty.setRatingFitchShortTerm(ratingFitchShortTerm);
            }

            if (attributes.getIndex("ratingJCRAShortTerm") != -1) {
                RatingsJCRAShortTerm ratingJCRAShortTerm = RatingsJCRAShortTerm.fromString(attributes.getValue("ratingJCRAShortTerm"));
                inputCounterparty.setRatingJCRAShortTerm(ratingJCRAShortTerm);
            }

            if (attributes.getIndex("ratingMoodysShortTerm") != -1) {
                RatingsMoodysShortTerm ratingMoodysShortTerm = RatingsMoodysShortTerm.fromString(attributes.getValue("ratingMoodysShortTerm"));
                inputCounterparty.setRatingMoodysShortTerm(ratingMoodysShortTerm);
            }

            if (attributes.getIndex("ratingSandPShortTerm") != -1) {
                RatingsSandPShortTerm ratingSandPShortTerm = RatingsSandPShortTerm.fromString(attributes.getValue("ratingSandPShortTerm"));
                inputCounterparty.setRatingSandPShortTerm(ratingSandPShortTerm);
            }

            if (attributes.getIndex("ratingFitchCIU") != -1) {
                RatingsFitchCIU ratingFitchCIU = RatingsFitchCIU.fromString(attributes.getValue("ratingFitchCIU"));
                inputCounterparty.setRatingFitchCIU(ratingFitchCIU);
            }

            if (attributes.getIndex("ratingMoodysCIU") != -1) {
                RatingsMoodysCIU ratingMoodysCIU = RatingsMoodysCIU.fromString(attributes.getValue("ratingMoodysCIU"));
                inputCounterparty.setRatingMoodysCIU(ratingMoodysCIU);
            }

            if (attributes.getIndex("ratingSandPFundCreditQualityRatingsCIU") != -1) {
                RatingsSandPFundCreditQualityRatingsCIU ratingSandPFundCreditQualityRatingsCIU = RatingsSandPFundCreditQualityRatingsCIU.fromString(attributes.getValue("ratingSandPFundCreditQualityRatingsCIU"));
                inputCounterparty.setRatingSandPFundCreditQualityRatingsCIU(ratingSandPFundCreditQualityRatingsCIU);
            }

            if (attributes.getIndex("ratingSandPPrincipalStabilityFundRatingsCIU") != -1) {
                RatingsSandPPrincipalStabilityFundRatingsCIU ratingSandPPrincipalStabilityFundRatingsCIU = RatingsSandPPrincipalStabilityFundRatingsCIU.fromString(attributes.getValue("ratingSandPPrincipalStabilityFundRatingsCIU"));
                inputCounterparty.setRatingSandPPrincipalStabilityFundRatingsCIU(ratingSandPPrincipalStabilityFundRatingsCIU);
            }

            addInputCounterpartyService.saveInputCounterparty(inputCounterparty);

        }
        else if (qName.equalsIgnoreCase("Transaction")) {

            InputTransaction inputTransaction = new InputTransaction();

            int id = Integer.parseInt(attributes.getValue("id"));
            inputTransaction.setId(id);

            Integer counterpartyId = Integer.valueOf(attributes.getValue("counterpartyId"));
            InputCounterparty inputCounterparty = getInputCounterpartySingleService.findInputCounterpartyWithId(counterpartyId);
            inputTransaction.setInputCounterparty(inputCounterparty);

            if (attributes.getIndex("nettingSetId") != -1) {
                Integer nettingSetId = Integer.valueOf(attributes.getValue("nettingSetId"));
                inputTransaction.setNettingSetId(nettingSetId);
            }

            if (attributes.getIndex("category") != -1) {
                TransactionCategories category = TransactionCategories.fromString(attributes.getValue("category"));
                inputTransaction.setCategory(category);
            }

            Double currentMarketValue = Double.valueOf(attributes.getValue("currentMarketValue"));
            inputTransaction.setCurrentMarketValue(currentMarketValue);

            if (attributes.getIndex("nominalValue") != -1) {
                Double nominalValue = Double.valueOf(attributes.getValue("nominalValue"));
                inputTransaction.setNominalValue(nominalValue);
            }

            Integer residualMaturity = Integer.valueOf(attributes.getValue("residualMaturity"));
            inputTransaction.setResidualMaturity(residualMaturity);

            if (attributes.getIndex("optionWriterPosition") != -1) {
                Boolean optionWriterPosition = Boolean.valueOf(attributes.getValue("optionWriterPosition"));
                inputTransaction.setOptionWriterPosition(optionWriterPosition);
            }

            if (attributes.getIndex("basisSwap") != -1) {
                Boolean basisSwap = Boolean.valueOf(attributes.getValue("basisSwap"));
                inputTransaction.setBasisSwap(basisSwap);
            }

            if (attributes.getIndex("cvaHedge") != -1) {
                Boolean cvaHedge = Boolean.valueOf(attributes.getValue("cvaHedge"));
                inputTransaction.setCvaHedge(cvaHedge);
            }

            if (attributes.getIndex("referencedCounterpartyId") != -1) {
                Integer referencedCounterpartyId = Integer.valueOf(attributes.getValue("referencedCounterpartyId"));
                inputTransaction.setReferencedCounterpartyId(referencedCounterpartyId);
            }

            addInputTransactionService.saveInputTransaction(inputTransaction);

        }
        else if (qName.equalsIgnoreCase("Collateral")) {

            InputCollateral inputCollateral = new InputCollateral();

            int id = Integer.parseInt(attributes.getValue("id"));
            inputCollateral.setId(id);

            if (attributes.getIndex("netCollateralReceived") != -1) {
                Double netCollateralReceived = Double.valueOf(attributes.getValue("netCollateralReceived"));
                inputCollateral.setNetCollateralReceived(netCollateralReceived);
            }

            addInputCollateralService.saveInputCollateral(inputCollateral);

        }

    }


}
