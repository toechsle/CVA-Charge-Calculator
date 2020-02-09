package com.cva_risk.model;


import javax.persistence.*;

@Entity
@Table(name="IntermediateResultsTransactions")
public class IntermediateResultsTransaction {

    @Id
    @Column(name="id")
    private int id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="counterparty_id", referencedColumnName="id")
    private IntermediateResultsCounterparty intermediateResultsCounterparty;

    @Column(name="volatility_rate")
    private Double volatilityRate;

    @Column(name="current_replacement_cost")
    private Double currentReplacementCost;

    @Column(name="add_on")
    private Double addOn;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="id", referencedColumnName="id")
    private InputTransaction inputTransaction;


    public IntermediateResultsTransaction() {
    }


    public int getId() {
        return id;
    }

    public Double getVolatilityRate() {
        return volatilityRate;
    }

    public Double getCurrentReplacementCost() {
        return currentReplacementCost;
    }

    public Double getAddOn() {
        return addOn;
    }

    public InputTransaction getInputTransaction() {
        return inputTransaction;
    }

    public IntermediateResultsCounterparty getIntermediateResultsCounterparty() {
        return intermediateResultsCounterparty;
    }

    public int getIntermediateResultsCounterpartyId() {
        return intermediateResultsCounterparty.getId();
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setVolatilityRate(Double volatilityRate) {
        this.volatilityRate = volatilityRate;
    }

    public void setCurrentReplacementCost(Double currentReplacementCost) {
        this.currentReplacementCost = currentReplacementCost;
    }

    public void setAddOn(Double addOn) {
        this.addOn = addOn;
    }

    public void setInputTransaction(InputTransaction inputTransaction) {
        this.inputTransaction = inputTransaction;
    }

    public void setIntermediateResultsCounterparty(IntermediateResultsCounterparty intermediateResultsCounterparty) {
        this.intermediateResultsCounterparty = intermediateResultsCounterparty;
    }

}
