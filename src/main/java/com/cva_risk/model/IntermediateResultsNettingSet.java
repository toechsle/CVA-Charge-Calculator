package com.cva_risk.model;

import javax.persistence.*;


@Entity
@Table(name="IntermediateResultsNettingSets")
public class IntermediateResultsNettingSet {

    @Id
    @Column(name="id")
    private int id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="counterparty_id", referencedColumnName="id")
    private IntermediateResultsCounterparty intermediateResultsCounterparty;

    @Column(name="discounted_exposure_value_after_collateral")
    private Double discountedExposureValueAfterCollateral;

    @Column(name="exposure_value_after_collateral")
    private Double exposureValueAfterCollateral;

    @Column(name="exposure_value_before_collateral")
    private Double exposureValueBeforeCollateral;

    @Column(name="effective_residual_maturity")
    private Double effectiveResidualMaturity;

    @Column(name="residual_maturity")
    private Double residualMaturity;

    @Column(name="nominal_value")
    private Double nominalValue;

    @Column(name="net_replacement_cost")
    private Double netReplacementCost;

    @Column(name="gross_replacement_cost")
    private Double grossReplacementCost;

    @Column(name="net_to_gross_ratio")
    private Double netToGrossRatio;

    @Column(name="pce_gross")
    private Double pceGross;

    @Column(name="pce_red")
    private Double pceRed;


    public IntermediateResultsNettingSet() {
    }


    public int getId() {
        return id;
    }

    public Double getDiscountedExposureValueAfterCollateral() {
        return discountedExposureValueAfterCollateral;
    }

    public Double getExposureValueAfterCollateral() {
        return exposureValueAfterCollateral;
    }

    public Double getExposureValueBeforeCollateral() {
        return exposureValueBeforeCollateral;
    }

    public Double getEffectiveResidualMaturity() {
        return effectiveResidualMaturity;
    }

    public Double getResidualMaturity() {
        return residualMaturity;
    }

    public Double getNominalValue() {
        return nominalValue;
    }

    public Double getNetReplacementCost() {
        return netReplacementCost;
    }

    public Double getGrossReplacementCost() {
        return grossReplacementCost;
    }

    public Double getNetToGrossRatio() {
        return netToGrossRatio;
    }

    public Double getPceGross() {
        return pceGross;
    }

    public Double getPceRed() {
        return pceRed;
    }

    public IntermediateResultsCounterparty getIntermediateResultsCounterparty() {
        return intermediateResultsCounterparty;
    }

    public int getIntermediateResultsCounterpartyId() {
        return getIntermediateResultsCounterparty().getId();
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDiscountedExposureValueAfterCollateral(Double discountedExposureValueAfterCollateral) {
        this.discountedExposureValueAfterCollateral = discountedExposureValueAfterCollateral;
    }

    public void setExposureValueAfterCollateral(Double exposureValueAfterCollateral) {
        this.exposureValueAfterCollateral = exposureValueAfterCollateral;
    }

    public void setExposureValueBeforeCollateral(Double exposureValueBeforeCollateral) {
        this.exposureValueBeforeCollateral = exposureValueBeforeCollateral;
    }

    public void setEffectiveResidualMaturity(Double effectiveResidualMaturity) {
        this.effectiveResidualMaturity = effectiveResidualMaturity;
    }

    public void setResidualMaturity(Double residualMaturity) {
        this.residualMaturity = residualMaturity;
    }

    public void setNominalValue(Double nominalValue) {
        this.nominalValue = nominalValue;
    }

    public void setNetReplacementCost(Double netReplacementCost) {
        this.netReplacementCost = netReplacementCost;
    }

    public void setGrossReplacementCost(Double grossReplacementCost) {
        this.grossReplacementCost = grossReplacementCost;
    }

    public void setNetToGrossRatio(Double netToGrossRatio) {
        this.netToGrossRatio = netToGrossRatio;
    }

    public void setPceGross(Double pceGross) {
        this.pceGross = pceGross;
    }

    public void setPceRed(Double pceRed) {
        this.pceRed = pceRed;
    }

    public void setIntermediateResultsCounterparty(IntermediateResultsCounterparty intermediateResultsCounterparty) {
        this.intermediateResultsCounterparty = intermediateResultsCounterparty;
    }


}
