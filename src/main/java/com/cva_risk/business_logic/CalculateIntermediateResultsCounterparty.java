package com.cva_risk.business_logic;


import com.cva_risk.database_access.services.AddIntermediateResultsCounterpartyServiceImpl;
import com.cva_risk.database_access.services.GetInputCounterpartyAllServiceImpl;
import com.cva_risk.model.InputCounterparty;
import com.cva_risk.model.IntermediateResultsCounterparty;
import com.cva_risk.utils.*;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@SpringComponent
public class CalculateIntermediateResultsCounterparty {

    @Autowired
    private GetInputCounterpartyAllServiceImpl getInputCounterpartyAllService;

    @Autowired
    private AddIntermediateResultsCounterpartyServiceImpl addIntermediateResultsCounterpartyService;

    private List<Double> listOfWeights = new ArrayList<>();


    public void execute(){

        IntermediateResultsCounterparty intermediateResultsCounterpartyDAO = new IntermediateResultsCounterparty();


        List<InputCounterparty> inputCounterpartyList = getInputCounterpartyAllService.findAllInputCounterparties();

        for (InputCounterparty inputCounterparty : inputCounterpartyList) {

            intermediateResultsCounterpartyDAO.setId(inputCounterparty.getId());
            intermediateResultsCounterpartyDAO.setName(inputCounterparty.getName());


            RatingsCRAG ratingCRAG = inputCounterparty.getRatingCRAG();
            if (ratingCRAG == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(null);
            }
            else if (ratingCRAG.equals(RatingsCRAG.AAA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(0.7);
            }
            else if (ratingCRAG.equals(RatingsCRAG.AAplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(0.8);
            }
            else if (ratingCRAG.equals(RatingsCRAG.AA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(0.8);
            }
            else if (ratingCRAG.equals(RatingsCRAG.AAminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(0.8);
            }
            else if (ratingCRAG.equals(RatingsCRAG.Aplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(0.8);
            }
            else if (ratingCRAG.equals(RatingsCRAG.A)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(0.8);
            }
            else if (ratingCRAG.equals(RatingsCRAG.Aminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(0.8);
            }
            else if (ratingCRAG.equals(RatingsCRAG.BBBplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(1.0);
            }
            else if (ratingCRAG.equals(RatingsCRAG.BBB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(1.0);
            }
            else if (ratingCRAG.equals(RatingsCRAG.BBBminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(1.0);
            }
            else if (ratingCRAG.equals(RatingsCRAG.BBplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(2.0);
            }
            else if (ratingCRAG.equals(RatingsCRAG.BB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(2.0);
            }
            else if (ratingCRAG.equals(RatingsCRAG.BBminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(2.0);
            }
            else if (ratingCRAG.equals(RatingsCRAG.Bplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(3.0);
            }
            else if (ratingCRAG.equals(RatingsCRAG.B)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(3.0);
            }
            else if (ratingCRAG.equals(RatingsCRAG.Bminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(3.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingCRAG(10.0);
            }


            RatingsDBRS ratingDBRS = inputCounterparty.getRatingDBRS();
            if (ratingDBRS == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(null);
            }
            else if (ratingDBRS.equals(RatingsDBRS.AAA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(0.7);
            }
            else if (ratingDBRS.equals(RatingsDBRS.AAhigh)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(0.7);
            }
            else if (ratingDBRS.equals(RatingsDBRS.AA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(0.7);
            }
            else if (ratingDBRS.equals(RatingsDBRS.AAlow)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(0.7);
            }
            else if (ratingDBRS.equals(RatingsDBRS.Ahigh)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(0.8);
            }
            else if (ratingDBRS.equals(RatingsDBRS.A)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(0.8);
            }
            else if (ratingDBRS.equals(RatingsDBRS.Alow)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(0.8);
            }
            else if (ratingDBRS.equals(RatingsDBRS.BBBhigh)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(1.0);
            }
            else if (ratingDBRS.equals(RatingsDBRS.BBB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(1.0);
            }
            else if (ratingDBRS.equals(RatingsDBRS.BBBlow)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(1.0);
            }
            else if (ratingDBRS.equals(RatingsDBRS.BBhigh)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(2.0);
            }
            else if (ratingDBRS.equals(RatingsDBRS.BB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(2.0);
            }
            else if (ratingDBRS.equals(RatingsDBRS.BBlow)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(2.0);
            }
            else if (ratingDBRS.equals(RatingsDBRS.Bhigh)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(3.0);
            }
            else if (ratingDBRS.equals(RatingsDBRS.B)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(3.0);
            }
            else if (ratingDBRS.equals(RatingsDBRS.Blow)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(3.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRS(10.0);
            }



            RatingsEHRG ratingEHRG = inputCounterparty.getRatingEHRG();
            if (ratingEHRG == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(null);
            }
            else if (ratingEHRG.equals(RatingsEHRG.AAA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(0.7);
            }
            else if (ratingEHRG.equals(RatingsEHRG.AAplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(0.8);
            }
            else if (ratingEHRG.equals(RatingsEHRG.AA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(0.8);
            }
            else if (ratingEHRG.equals(RatingsEHRG.AAminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(0.8);
            }
            else if (ratingEHRG.equals(RatingsEHRG.Aplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(0.8);
            }
            else if (ratingEHRG.equals(RatingsEHRG.A)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(0.8);
            }
            else if (ratingEHRG.equals(RatingsEHRG.Aminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(0.8);
            }
            else if (ratingEHRG.equals(RatingsEHRG.BBBplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(1.0);
            }
            else if (ratingEHRG.equals(RatingsEHRG.BBB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(1.0);
            }
            else if (ratingEHRG.equals(RatingsEHRG.BBBminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(1.0);
            }
            else if (ratingEHRG.equals(RatingsEHRG.BBplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(2.0);
            }
            else if (ratingEHRG.equals(RatingsEHRG.BB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(2.0);
            }
            else if (ratingEHRG.equals(RatingsEHRG.BBminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(2.0);
            }
            else if (ratingEHRG.equals(RatingsEHRG.Bplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(3.0);
            }
            else if (ratingEHRG.equals(RatingsEHRG.B)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(3.0);
            }
            else if (ratingEHRG.equals(RatingsEHRG.Bminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(3.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingEHRG(10.0);
            }


            RatingsFitch ratingFitch = inputCounterparty.getRatingFitch();
            if (ratingFitch == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(null);
            }
            else if (ratingFitch.equals(RatingsFitch.AAA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(0.7);
            }
            else if (ratingFitch.equals(RatingsFitch.AAplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(0.7);
            }
            else if (ratingFitch.equals(RatingsFitch.AA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(0.7);
            }
            else if (ratingFitch.equals(RatingsFitch.AAminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(0.7);
            }
            else if (ratingFitch.equals(RatingsFitch.Aplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(0.8);
            }
            else if (ratingFitch.equals(RatingsFitch.A)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(0.8);
            }
            else if (ratingFitch.equals(RatingsFitch.Aminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(0.8);
            }
            else if (ratingFitch.equals(RatingsFitch.BBBplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(1.0);
            }
            else if (ratingFitch.equals(RatingsFitch.BBB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(1.0);
            }
            else if (ratingFitch.equals(RatingsFitch.BBBminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(1.0);
            }
            else if (ratingFitch.equals(RatingsFitch.BBplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(2.0);
            }
            else if (ratingFitch.equals(RatingsFitch.BB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(2.0);
            }
            else if (ratingFitch.equals(RatingsFitch.BBminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(2.0);
            }
            else if (ratingFitch.equals(RatingsFitch.Bplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(3.0);
            }
            else if (ratingFitch.equals(RatingsFitch.B)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(3.0);
            }
            else if (ratingFitch.equals(RatingsFitch.Bminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(3.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingFitch(10.0);
            }


            RatingsJCRA ratingJCRA = inputCounterparty.getRatingJCRA();
            if (ratingJCRA == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(null);
            }
            else if (ratingJCRA.equals(RatingsJCRA.AAA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(0.7);
            }
            else if (ratingJCRA.equals(RatingsJCRA.AAplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(0.7);
            }
            else if (ratingJCRA.equals(RatingsJCRA.AA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(0.7);
            }
            else if (ratingJCRA.equals(RatingsJCRA.AAminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(0.7);
            }
            else if (ratingJCRA.equals(RatingsJCRA.Aplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(0.8);
            }
            else if (ratingJCRA.equals(RatingsJCRA.A)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(0.8);
            }
            else if (ratingJCRA.equals(RatingsJCRA.Aminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(0.8);
            }
            else if (ratingJCRA.equals(RatingsJCRA.BBBplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(1.0);
            }
            else if (ratingJCRA.equals(RatingsJCRA.BBB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(1.0);
            }
            else if (ratingJCRA.equals(RatingsJCRA.BBBminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(1.0);
            }
            else if (ratingJCRA.equals(RatingsJCRA.BBplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(2.0);
            }
            else if (ratingJCRA.equals(RatingsJCRA.BB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(2.0);
            }
            else if (ratingJCRA.equals(RatingsJCRA.BBminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(2.0);
            }
            else if (ratingJCRA.equals(RatingsJCRA.Bplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(3.0);
            }
            else if (ratingJCRA.equals(RatingsJCRA.B)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(3.0);
            }
            else if (ratingJCRA.equals(RatingsJCRA.Bminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(3.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRA(10.0);
            }


            RatingsMoodys ratingMoodys = inputCounterparty.getRatingMoodys();
            if (ratingMoodys == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(null);
            }
            else if (ratingMoodys.equals(RatingsMoodys.Aaa)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(0.7);
            }
            else if (ratingMoodys.equals(RatingsMoodys.Aa1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(0.7);
            }
            else if (ratingMoodys.equals(RatingsMoodys.Aa2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(0.7);
            }
            else if (ratingMoodys.equals(RatingsMoodys.Aa3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(0.7);
            }
            else if (ratingMoodys.equals(RatingsMoodys.A1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(0.8);
            }
            else if (ratingMoodys.equals(RatingsMoodys.A2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(0.8);
            }
            else if (ratingMoodys.equals(RatingsMoodys.A3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(0.8);
            }
            else if (ratingMoodys.equals(RatingsMoodys.Baa1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(1.0);
            }
            else if (ratingMoodys.equals(RatingsMoodys.Baa2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(1.0);
            }
            else if (ratingMoodys.equals(RatingsMoodys.Baa3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(1.0);
            }
            else if (ratingMoodys.equals(RatingsMoodys.Ba1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(2.0);
            }
            else if (ratingMoodys.equals(RatingsMoodys.Ba2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(2.0);
            }
            else if (ratingMoodys.equals(RatingsMoodys.Ba3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(2.0);
            }
            else if (ratingMoodys.equals(RatingsMoodys.B1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(3.0);
            }
            else if (ratingMoodys.equals(RatingsMoodys.B2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(3.0);
            }
            else if (ratingMoodys.equals(RatingsMoodys.B3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(3.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodys(10.0);
            }


            RatingsSandP ratingSandP = inputCounterparty.getRatingSandP();
            if (ratingSandP == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(null);
            }
            else if (ratingSandP.equals(RatingsSandP.AAA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(0.7);
            }
            else if (ratingSandP.equals(RatingsSandP.AAplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(0.7);
            }
            else if (ratingSandP.equals(RatingsSandP.AA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(0.7);
            }
            else if (ratingSandP.equals(RatingsSandP.AAminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(0.7);
            }
            else if (ratingSandP.equals(RatingsSandP.Aplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(0.8);
            }
            else if (ratingSandP.equals(RatingsSandP.A)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(0.8);
            }
            else if (ratingSandP.equals(RatingsSandP.Aminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(0.8);
            }
            else if (ratingSandP.equals(RatingsSandP.BBBplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(1.0);
            }
            else if (ratingSandP.equals(RatingsSandP.BBB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(1.0);
            }
            else if (ratingSandP.equals(RatingsSandP.BBBminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(1.0);
            }
            else if (ratingSandP.equals(RatingsSandP.BBplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(2.0);
            }
            else if (ratingSandP.equals(RatingsSandP.BB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(2.0);
            }
            else if (ratingSandP.equals(RatingsSandP.BBminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(2.0);
            }
            else if (ratingSandP.equals(RatingsSandP.Bplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(3.0);
            }
            else if (ratingSandP.equals(RatingsSandP.B)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(3.0);
            }
            else if (ratingSandP.equals(RatingsSandP.Bminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(3.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingSandP(10.0);
            }


            RatingsDBRSShortTerm ratingDBRSShortTerm = inputCounterparty.getRatingDBRSShortTerm();
            if (ratingDBRSShortTerm == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRSShortTerm(null);
            }
            else if (ratingDBRSShortTerm.equals(RatingsDBRSShortTerm.Rminus1_high)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRSShortTerm(0.7);
            }
            else if (ratingDBRSShortTerm.equals(RatingsDBRSShortTerm.Rminus1_middle)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRSShortTerm(0.7);
            }
            else if (ratingDBRSShortTerm.equals(RatingsDBRSShortTerm.Rminus1_low)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRSShortTerm(0.7);
            }
            else if (ratingDBRSShortTerm.equals(RatingsDBRSShortTerm.Rminus2_high)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRSShortTerm(0.8);
            }
            else if (ratingDBRSShortTerm.equals(RatingsDBRSShortTerm.Rminus2_middle)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRSShortTerm(0.8);
            }
            else if (ratingDBRSShortTerm.equals(RatingsDBRSShortTerm.Rminus2_low)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRSShortTerm(0.8);
            }
            else if (ratingDBRSShortTerm.equals(RatingsDBRSShortTerm.Rminus3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRSShortTerm(1.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingDBRSShortTerm(2.0);
            }


            RatingsFitchShortTerm ratingFitchShortTerm = inputCounterparty.getRatingFitchShortTerm();
            if (ratingFitchShortTerm == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchShortTerm(null);
            }
            else if (ratingFitchShortTerm.equals(RatingsFitchShortTerm.F1plus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchShortTerm(0.7);
            }
            else if (ratingFitchShortTerm.equals(RatingsFitchShortTerm.F1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchShortTerm(0.7);
            }
            else if (ratingFitchShortTerm.equals(RatingsFitchShortTerm.F2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchShortTerm(0.8);
            }
            else if (ratingFitchShortTerm.equals(RatingsFitchShortTerm.F3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchShortTerm(1.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchShortTerm(2.0);
            }


            RatingsJCRAShortTerm ratingJCRAShortTerm = inputCounterparty.getRatingJCRAShortTerm();
            if (ratingJCRAShortTerm == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRAShortTerm(null);
            }
            else if (ratingJCRAShortTerm.equals(ratingJCRAShortTerm.Jminus1plus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRAShortTerm(0.7);
            }
            else if (ratingJCRAShortTerm.equals(ratingJCRAShortTerm.Jminus1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRAShortTerm(0.7);
            }
            else if (ratingJCRAShortTerm.equals(ratingJCRAShortTerm.Jminus2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRAShortTerm(0.8);
            }
            else if (ratingJCRAShortTerm.equals(ratingJCRAShortTerm.Jminus3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRAShortTerm(1.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingJCRAShortTerm(2.0);
            }


            RatingsMoodysShortTerm ratingMoodysShortTerm = inputCounterparty.getRatingMoodysShortTerm();
            if (ratingMoodysShortTerm == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysShortTerm(null);
            }
            else if (ratingMoodysShortTerm.equals(RatingsMoodysShortTerm.Pminus1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysShortTerm(0.7);
            }
            else if (ratingMoodysShortTerm.equals(RatingsMoodysShortTerm.Pminus2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysShortTerm(0.8);
            }
            else if (ratingMoodysShortTerm.equals(RatingsMoodysShortTerm.Pminus3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysShortTerm(1.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysShortTerm(2.0);
            }


            RatingsSandPShortTerm ratingSandPShortTerm = inputCounterparty.getRatingSandPShortTerm();
            if (ratingSandPShortTerm == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPShortTerm(null);
            }
            else if (ratingSandPShortTerm.equals(RatingsSandPShortTerm.Aminus1plus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPShortTerm(0.7);
            }
            else if (ratingSandPShortTerm.equals(RatingsSandPShortTerm.Aminus1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPShortTerm(0.7);
            }
            else if (ratingSandPShortTerm.equals(RatingsSandPShortTerm.Aminus2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPShortTerm(0.8);
            }
            else if (ratingSandPShortTerm.equals(RatingsSandPShortTerm.Aminus3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPShortTerm(1.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPShortTerm(2.0);
            }


            RatingsFitchCIU ratingFitchCIU = inputCounterparty.getRatingFitchCIU();
            if (ratingFitchCIU == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(null);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.AAA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(0.7);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.AAplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(0.7);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.AA)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(0.7);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.AAminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(0.7);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.Aplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(0.8);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.A)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(0.8);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.Aminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(0.8);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.BBBplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(1.0);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.BBB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(1.0);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.BBBminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(1.0);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.BBplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(2.0);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.BB)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(2.0);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.BBminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(2.0);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.Bplus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(3.0);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.B)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(3.0);
            }
            else if (ratingFitchCIU.equals(RatingsFitchCIU.Bminus)) {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(3.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingFitchCIU(10.0);
            }


            RatingsMoodysCIU ratingMoodysCIU = inputCounterparty.getRatingMoodysCIU();
            if (ratingMoodysCIU == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(null);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.Aaa)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(0.7);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.Aa1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(0.7);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.Aa2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(0.7);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.Aa3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(0.7);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.A1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(0.8);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.A2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(0.8);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.A3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(0.8);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.Baa1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(1.0);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.Baa2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(1.0);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.Baa3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(1.0);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.Ba1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(2.0);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.Ba2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(2.0);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.Ba3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(2.0);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.B1)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(3.0);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.B2)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(3.0);
            }
            else if (ratingMoodysCIU.equals(RatingsMoodysCIU.B3)) {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(3.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingMoodysCIU(10.0);
            }


            RatingsSandPFundCreditQualityRatingsCIU ratingSandPFundCreditQualityRatingsCIU = inputCounterparty.getRatingSandPFundCreditQualityRatingsCIU();
            if (ratingSandPFundCreditQualityRatingsCIU == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(null);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.AAA_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(0.7);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.AAplus_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(0.7);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.AA_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(0.7);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.AAminus_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(0.7);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.Aplus_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(0.8);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.A_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(0.8);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.Aminus_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(0.8);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.BBBplus_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(1.0);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.BBB_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(1.0);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.BBBminus_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(1.0);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.BBplus_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(2.0);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.BB_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(2.0);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.BBminus_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(2.0);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.Bplus_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(3.0);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.B_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(3.0);
            }
            else if (ratingSandPFundCreditQualityRatingsCIU.equals(RatingsSandPFundCreditQualityRatingsCIU.Bminus_f)) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(3.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPFundCreditQualityRatingsCIU(10.0);
            }


            RatingsSandPPrincipalStabilityFundRatingsCIU ratingSandPPrincipalStabilityFundRatingsCIU = inputCounterparty.getRatingSandPPrincipalStabilityFundRatingsCIU();
            if (ratingSandPPrincipalStabilityFundRatingsCIU == null) {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(null);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.AAA_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(0.7);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.AAplus_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(0.7);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.AA_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(0.7);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.AAminus_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(0.7);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.Aplus_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(0.8);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.A_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(0.8);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.Aminus_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(0.8);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.BBBplus_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(1.0);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.BBB_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(1.0);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.BBBminus_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(1.0);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.BBplus_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(2.0);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.BB_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(2.0);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.BBminus_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(2.0);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.Bplus_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(3.0);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.B_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(3.0);
            }
            else if (ratingSandPPrincipalStabilityFundRatingsCIU.equals(RatingsSandPPrincipalStabilityFundRatingsCIU.Bminus_m)){
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(3.0);
            }
            else {
                intermediateResultsCounterpartyDAO.setWeightRatingSandPPrincipalStabilityFundRatingsCIU(10.0);
            }

            listOfWeights.clear();
            Double weightImpliedByRating;

            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingCRAG();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingDBRS();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingEHRG();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingFitch();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingJCRA();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingMoodys();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingSandP();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingDBRSShortTerm();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingFitchShortTerm();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingJCRAShortTerm();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingMoodysShortTerm();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingSandPShortTerm();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingFitchCIU();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingMoodysCIU();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingSandPFundCreditQualityRatingsCIU();
            updateList(weightImpliedByRating);
            weightImpliedByRating = intermediateResultsCounterpartyDAO.getWeightRatingSandPPrincipalStabilityFundRatingsCIU();
            updateList(weightImpliedByRating);

            double weight = calculateWeight(listOfWeights, inputCounterparty);
            intermediateResultsCounterpartyDAO.setWeight(weight);

            intermediateResultsCounterpartyDAO.setInputCounterparty(inputCounterparty);

            addIntermediateResultsCounterpartyService.saveIntermediateResultsCounterparty(intermediateResultsCounterpartyDAO);

        }

    }


    private void updateList(Double weight) {
        if (weight == null) {
            return;
        }
        else {
            listOfWeights.add(weight);
        }
    }

    private double calculateWeight(List listOfWeights, InputCounterparty inputCounterparty) {

        double weight;

        if (listOfWeights.isEmpty()) {
            Integer creditQualityStepBasedOnIRBA = inputCounterparty.getCreditQualityStepBasedOnIRBA();
            if (creditQualityStepBasedOnIRBA != null) {
                weight = mapCreditQualityStepToWeight(creditQualityStepBasedOnIRBA);
            }
            else {
                Boolean article128 = inputCounterparty.getArticle128();
                if(article128 == true) {
                    weight = 3.0;
                }
                else {
                    weight = 1.0;
                }
            }
        }
        else {
            int indexOfMinWeight = getIndexOfMinValueOfList(listOfWeights);
            double minWeight = (double) listOfWeights.remove(indexOfMinWeight);

            if (listOfWeights.isEmpty()) {
                weight = minWeight;
            }
            else {
                indexOfMinWeight = getIndexOfMinValueOfList(listOfWeights);
                double minWeight2 = (double) listOfWeights.remove(indexOfMinWeight);

                weight = Math.max(minWeight, minWeight2);
            }
        }

        return weight;
    }

    private int getIndexOfMinValueOfList(List<Double> list) {
        int indexOfMinValue = list.indexOf(Collections.min(list));
        return indexOfMinValue;
    }

    private double mapCreditQualityStepToWeight(int creditQualityStep) {

        double weight;

        if (creditQualityStep == 1) {
            weight = 0.7;
        }
        else if (creditQualityStep == 2) {
            weight = 0.8;
        }
        else if (creditQualityStep == 3) {
            weight = 1.0;
        }
        else if (creditQualityStep == 4) {
            weight = 2.0;
        }
        else if (creditQualityStep == 5) {
            weight = 3.0;
        }
        else {
            weight = 10.0;
        }

        return weight;
    }


}
