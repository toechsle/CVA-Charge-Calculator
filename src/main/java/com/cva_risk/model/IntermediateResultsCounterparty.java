package com.cva_risk.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="IntermediateResultsCounterparties")
public class IntermediateResultsCounterparty {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="weight_rating_crag")
    private Double weightRatingCRAG;

    @Column(name="weight_rating_dbrs")
    private Double weightRatingDBRS;

    @Column(name="weight_rating_ehrg")
    private Double weightRatingEHRG;

    @Column(name="weight_rating_fitch")
    private Double weightRatingFitch;

    @Column(name="weight_rating_jcra")
    private Double weightRatingJCRA;

    @Column(name="weight_rating_moodys")
    private Double weightRatingMoodys;

    @Column(name="weight_rating_s_and_p")
    private Double weightRatingSandP;

    @Column(name="weight_rating_dbrs_short_term")
    private Double weightRatingDBRSShortTerm;

    @Column(name="weight_rating_fitch_short_term")
    private Double weightRatingFitchShortTerm;

    @Column(name="weight_rating_jcra_short_term")
    private Double weightRatingJCRAShortTerm;

    @Column(name="weight_rating_moodys_short_term")
    private Double weightRatingMoodysShortTerm;

    @Column(name="weight_rating_s_and_p_short_term")
    private Double weightRatingSandPShortTerm;

    @Column(name="weight_rating_fitch_ciu")
    private Double weightRatingFitchCIU;

    @Column(name="weight_rating_moodys_ciu")
    private Double weightRatingMoodysCIU;

    @Column(name="weight_rating_s_and_p_fund_credit_quality_ratings_ciu")
    private Double weightRatingSandPFundCreditQualityRatingsCIU;

    @Column(name="weight_rating_s_and_p_principal_stability_fund_ratings_ciu")
    private Double weightRatingSandPPrincipalStabilityFundRatingsCIU;

    @Column(name="weight")
    private Double weight;

    @Column(name="effective_residual_maturity")
    private Double effectiveResidualMaturity;

    @Column(name="ead")
    private Double ead;

    @Column(name="ead_discounted")
    private Double eadDiscounted;

    @Column(name="m_hedge_times_b")
    private Double mHedgeTimesB;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="id", referencedColumnName="id")
    private InputCounterparty inputCounterparty;

    @OneToMany(targetEntity=IntermediateResultsTransaction.class, mappedBy="intermediateResultsCounterparty", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<IntermediateResultsTransaction> intermediateResultsTransactionList;

    @OneToMany(targetEntity=IntermediateResultsNettingSet.class, mappedBy="intermediateResultsCounterparty", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<IntermediateResultsNettingSet> intermediateResultsNettingSetList;


    public IntermediateResultsCounterparty() {

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getWeightRatingCRAG() {
        return weightRatingCRAG;
    }

    public Double getWeightRatingDBRS() {
        return weightRatingDBRS;
    }

    public Double getWeightRatingEHRG() {
        return weightRatingEHRG;
    }

    public Double getWeightRatingFitch() {
        return weightRatingFitch;
    }

    public Double getWeightRatingJCRA() {
        return weightRatingJCRA;
    }

    public Double getWeightRatingMoodys() {
        return weightRatingMoodys;
    }

    public Double getWeightRatingSandP() {
        return weightRatingSandP;
    }

    public Double getWeightRatingDBRSShortTerm() {
        return weightRatingDBRSShortTerm;
    }

    public Double getWeightRatingFitchShortTerm() {
        return weightRatingFitchShortTerm;
    }

    public Double getWeightRatingJCRAShortTerm() {
        return weightRatingJCRAShortTerm;
    }

    public Double getWeightRatingMoodysShortTerm() {
        return weightRatingMoodysShortTerm;
    }

    public Double getWeightRatingSandPShortTerm() {
        return weightRatingSandPShortTerm;
    }

    public Double getWeightRatingFitchCIU() {
        return weightRatingFitchCIU;
    }

    public Double getWeightRatingMoodysCIU() {
        return weightRatingMoodysCIU;
    }

    public Double getWeightRatingSandPFundCreditQualityRatingsCIU() {
        return weightRatingSandPFundCreditQualityRatingsCIU;
    }

    public Double getWeightRatingSandPPrincipalStabilityFundRatingsCIU() {
        return weightRatingSandPPrincipalStabilityFundRatingsCIU;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getEffectiveResidualMaturity() {
        return effectiveResidualMaturity;
    }

    public Double getEad() {
        return ead;
    }

    public Double getEadDiscounted() {
        return eadDiscounted;
    }

    public Double getmHedgeTimesB() {
        return mHedgeTimesB;
    }

    public InputCounterparty getInputCounterparty() {
        return inputCounterparty;
    }

    public List<IntermediateResultsTransaction> getIntermediateResultsTransactionList() {
        return intermediateResultsTransactionList;
    }

    public List<IntermediateResultsNettingSet> getIntermediateResultsNettingSetList() {
        return intermediateResultsNettingSetList;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeightRatingCRAG(Double weightRatingCRAG) {
        this.weightRatingCRAG = weightRatingCRAG;
    }

    public void setWeightRatingDBRS(Double weightRatingDBRS) {
        this.weightRatingDBRS = weightRatingDBRS;
    }

    public void setWeightRatingEHRG(Double weightRatingEHRG) {
        this.weightRatingEHRG = weightRatingEHRG;
    }

    public void setWeightRatingFitch(Double weightRatingFitch) {
        this.weightRatingFitch = weightRatingFitch;
    }

    public void setWeightRatingJCRA(Double weightRatingJCRA) {
        this.weightRatingJCRA = weightRatingJCRA;
    }

    public void setWeightRatingMoodys(Double weightRatingMoodys) {
        this.weightRatingMoodys = weightRatingMoodys;
    }

    public void setWeightRatingSandP(Double weightRatingSandP) {
        this.weightRatingSandP = weightRatingSandP;
    }

    public void setWeightRatingDBRSShortTerm(Double weightRatingDBRSShortTerm) {
        this.weightRatingDBRSShortTerm = weightRatingDBRSShortTerm;
    }

    public void setWeightRatingFitchShortTerm(Double weightRatingFitchShortTerm) {
        this.weightRatingFitchShortTerm = weightRatingFitchShortTerm;
    }

    public void setWeightRatingJCRAShortTerm(Double weightRatingJCRAShortTerm) {
        this.weightRatingJCRAShortTerm = weightRatingJCRAShortTerm;
    }

    public void setWeightRatingMoodysShortTerm(Double weightRatingMoodysShortTerm) {
        this.weightRatingMoodysShortTerm = weightRatingMoodysShortTerm;
    }

    public void setWeightRatingSandPShortTerm(Double weightRatingSandPShortTerm) {
        this.weightRatingSandPShortTerm = weightRatingSandPShortTerm;
    }

    public void setWeightRatingFitchCIU(Double weightRatingFitchCIU) {
        this.weightRatingFitchCIU = weightRatingFitchCIU;
    }

    public void setWeightRatingMoodysCIU(Double weightRatingMoodysCIU) {
        this.weightRatingMoodysCIU = weightRatingMoodysCIU;
    }

    public void setWeightRatingSandPFundCreditQualityRatingsCIU(Double weightRatingSandPFundCreditQualityRatingsCIU) {
        this.weightRatingSandPFundCreditQualityRatingsCIU = weightRatingSandPFundCreditQualityRatingsCIU;
    }

    public void setWeightRatingSandPPrincipalStabilityFundRatingsCIU(Double weightRatingSandPPrincipalStabilityFundRatingsCIU) {
        this.weightRatingSandPPrincipalStabilityFundRatingsCIU = weightRatingSandPPrincipalStabilityFundRatingsCIU;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setEffectiveResidualMaturity(Double effectiveResidualMaturity) {
        this.effectiveResidualMaturity = effectiveResidualMaturity;
    }

    public void setEad(Double ead) {
        this.ead = ead;
    }

    public void setEadDiscounted(Double eadDiscounted) {
        this.eadDiscounted = eadDiscounted;
    }

    public void setmHedgeTimesB(Double mHedgeTimesB) {
        this.mHedgeTimesB = mHedgeTimesB;
    }

    public void setInputCounterparty(InputCounterparty inputCounterparty) {
        this.inputCounterparty = inputCounterparty;
    }

    public void setIntermediateResultsTransactionList(List<IntermediateResultsTransaction> intermediateResultsTransactionList) {
        this.intermediateResultsTransactionList = intermediateResultsTransactionList;
    }

    public void setIntermediateResultsNettingSetList(List<IntermediateResultsNettingSet> intermediateResultsNettingSetList) {
        this.intermediateResultsNettingSetList = intermediateResultsNettingSetList;
    }
}
