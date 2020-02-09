package com.cva_risk.model;

import com.cva_risk.utils.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="InputCounterparties")
public class InputCounterparty {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="credit_quality_step_based_on_irba")
    private Integer creditQualityStepBasedOnIRBA;

    @Column(name="article_128", columnDefinition="BOOLEAN default FALSE")
    private Boolean article128;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_crag")
    private RatingsCRAG ratingCRAG;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_dbrs")
    private RatingsDBRS ratingDBRS;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_ehrg")
    private RatingsEHRG ratingEHRG;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_fitch")
    private RatingsFitch ratingFitch;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_jcra")
    private RatingsJCRA ratingJCRA;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_moodys")
    private RatingsMoodys ratingMoodys;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_s_and_p")
    private RatingsSandP ratingSandP;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_dbrs_short_term")
    private RatingsDBRSShortTerm ratingDBRSShortTerm;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_fitch_short_term")
    private RatingsFitchShortTerm ratingFitchShortTerm;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_jcra_short_term")
    private RatingsJCRAShortTerm ratingJCRAShortTerm;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_moodys_short_term")
    private RatingsMoodysShortTerm ratingMoodysShortTerm;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_s_and_p_short_term")
    private RatingsSandPShortTerm ratingSandPShortTerm;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_fitch_ciu")
    private RatingsFitchCIU ratingFitchCIU;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_moodys_ciu")
    private RatingsMoodysCIU ratingMoodysCIU;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_s_and_p_fund_credit_quality_ratings_ciu")
    private RatingsSandPFundCreditQualityRatingsCIU ratingSandPFundCreditQualityRatingsCIU;

    @Enumerated(EnumType.STRING)
    @Column(name="rating_s_and_p_principal_stability_fund_ratings_ciu")
    private RatingsSandPPrincipalStabilityFundRatingsCIU ratingSandPPrincipalStabilityFundRatingsCIU;

    @OneToOne(mappedBy="inputCounterparty", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private IntermediateResultsCounterparty intermediateResultsCounterparty;

    @OneToMany(targetEntity=InputTransaction.class, mappedBy="inputCounterparty", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<InputTransaction> inputTransactionList;


    public InputCounterparty() {

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCreditQualityStepBasedOnIRBA() {
        return creditQualityStepBasedOnIRBA;
    }

    public Boolean getArticle128() {
        return article128;
    }

    public RatingsCRAG getRatingCRAG() {
        return ratingCRAG;
    }

    public RatingsDBRS getRatingDBRS() {
        return ratingDBRS;
    }

    public RatingsEHRG getRatingEHRG() {
        return ratingEHRG;
    }

    public RatingsFitch getRatingFitch() {
        return ratingFitch;
    }

    public RatingsJCRA getRatingJCRA() {
        return ratingJCRA;
    }

    public RatingsMoodys getRatingMoodys() {
        return ratingMoodys;
    }

    public RatingsSandP getRatingSandP() {
        return ratingSandP;
    }

    public RatingsDBRSShortTerm getRatingDBRSShortTerm() {
        return ratingDBRSShortTerm;
    }

    public RatingsFitchShortTerm getRatingFitchShortTerm() {
        return ratingFitchShortTerm;
    }

    public RatingsJCRAShortTerm getRatingJCRAShortTerm() {
        return ratingJCRAShortTerm;
    }

    public RatingsMoodysShortTerm getRatingMoodysShortTerm() {
        return ratingMoodysShortTerm;
    }

    public RatingsSandPShortTerm getRatingSandPShortTerm() {
        return ratingSandPShortTerm;
    }

    public RatingsFitchCIU getRatingFitchCIU() {
        return ratingFitchCIU;
    }

    public RatingsMoodysCIU getRatingMoodysCIU() {
        return ratingMoodysCIU;
    }

    public RatingsSandPFundCreditQualityRatingsCIU getRatingSandPFundCreditQualityRatingsCIU() {
        return ratingSandPFundCreditQualityRatingsCIU;
    }

    public RatingsSandPPrincipalStabilityFundRatingsCIU getRatingSandPPrincipalStabilityFundRatingsCIU() {
        return ratingSandPPrincipalStabilityFundRatingsCIU;
    }

    public IntermediateResultsCounterparty getIntermediateResultsCounterparty() {
        return intermediateResultsCounterparty;
    }

    public List<InputTransaction> getInputTransactionList() {
        return inputTransactionList;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreditQualityStepBasedOnIRBA(Integer creditQualityStepBasedOnIRBA) {
        this.creditQualityStepBasedOnIRBA = creditQualityStepBasedOnIRBA;
    }

    public void setArticle128(Boolean article128) {
        this.article128 = article128;
    }

    public void setRatingCRAG(RatingsCRAG ratingCRAG) {
        this.ratingCRAG = ratingCRAG;
    }

    public void setRatingDBRS(RatingsDBRS ratingDBRS) {
        this.ratingDBRS = ratingDBRS;
    }

    public void setRatingEHRG(RatingsEHRG ratingEHRG) {
        this.ratingEHRG = ratingEHRG;
    }

    public void setRatingFitch(RatingsFitch ratingFitch) {
        this.ratingFitch = ratingFitch;
    }

    public void setRatingJCRA(RatingsJCRA ratingJCRA) {
        this.ratingJCRA = ratingJCRA;
    }

    public void setRatingMoodys(RatingsMoodys ratingMoodys) {
        this.ratingMoodys = ratingMoodys;
    }

    public void setRatingSandP(RatingsSandP ratingSandP) {
        this.ratingSandP = ratingSandP;
    }

    public void setRatingDBRSShortTerm(RatingsDBRSShortTerm ratingDBRSShortTerm) {
        this.ratingDBRSShortTerm = ratingDBRSShortTerm;
    }

    public void setRatingFitchShortTerm(RatingsFitchShortTerm ratingFitchShortTerm) {
        this.ratingFitchShortTerm = ratingFitchShortTerm;
    }

    public void setRatingJCRAShortTerm(RatingsJCRAShortTerm ratingJCRAShortTerm) {
        this.ratingJCRAShortTerm = ratingJCRAShortTerm;
    }

    public void setRatingMoodysShortTerm(RatingsMoodysShortTerm ratingMoodysShortTerm) {
        this.ratingMoodysShortTerm = ratingMoodysShortTerm;
    }

    public void setRatingSandPShortTerm(RatingsSandPShortTerm ratingSandPShortTerm) {
        this.ratingSandPShortTerm = ratingSandPShortTerm;
    }

    public void setRatingFitchCIU(RatingsFitchCIU ratingFitchCIU) {
        this.ratingFitchCIU = ratingFitchCIU;
    }

    public void setRatingMoodysCIU(RatingsMoodysCIU ratingMoodysCIU) {
        this.ratingMoodysCIU = ratingMoodysCIU;
    }

    public void setRatingSandPFundCreditQualityRatingsCIU(RatingsSandPFundCreditQualityRatingsCIU ratingSandPFundCreditQualityRatingsCIU) {
        this.ratingSandPFundCreditQualityRatingsCIU = ratingSandPFundCreditQualityRatingsCIU;
    }

    public void setRatingSandPPrincipalStabilityFundRatingsCIU(RatingsSandPPrincipalStabilityFundRatingsCIU ratingSandPPrincipalStabilityFundRatingsCIU) {
        this.ratingSandPPrincipalStabilityFundRatingsCIU = ratingSandPPrincipalStabilityFundRatingsCIU;
    }

    public void setIntermediateResultsCounterparty(IntermediateResultsCounterparty intermediateResultsCounterparty) {
        this.intermediateResultsCounterparty = intermediateResultsCounterparty;
    }

    public void setInputTransactionList(List<InputTransaction> inputTransactionList) {
        this.inputTransactionList = inputTransactionList;
    }

}
