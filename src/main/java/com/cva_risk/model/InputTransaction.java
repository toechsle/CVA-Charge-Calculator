package com.cva_risk.model;

import com.cva_risk.utils.TransactionCategories;

import javax.persistence.*;


@Entity
@Table(name="InputTransactions")
public class InputTransaction {

    @Id
    @Column(name="id")
    private int id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="counterparty_id", referencedColumnName="id", nullable=false)
    private InputCounterparty inputCounterparty;

    @Column(name="netting_set_id")
    private Integer nettingSetId;

    @Enumerated(EnumType.STRING)
    @Column(name="category")
    private TransactionCategories category;

    @Column(name="current_market_value", nullable=false)
    private Double currentMarketValue;

    @Column(name="nominal_value")
    private Double nominalValue;

    @Column(name="residual_maturity", nullable=false)
    private Integer residualMaturity;

    @Column(name="option_writer_position", columnDefinition="BOOLEAN default FALSE")
    private Boolean optionWriterPosition;

    @Column(name="basis_swap", columnDefinition="BOOLEAN default FALSE")
    private Boolean basisSwap;

    @Column(name="cva_hedge", columnDefinition="BOOLEAN default FALSE")
    private Boolean cvaHedge;

    @Column(name="referenced_counterparty_id")
    private Integer referencedCounterpartyId;

    @OneToOne(mappedBy="inputTransaction", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private IntermediateResultsTransaction intermediateResultsTransaction;


    public InputTransaction() {

    }


    public int getId() {
        return id;
    }

    public InputCounterparty getInputCounterparty() {
        return inputCounterparty;
    }

    public Integer getNettingSetId() {
        return nettingSetId;
    }

    public TransactionCategories getCategory() {
        return category;
    }

    public Double getCurrentMarketValue() {
        return currentMarketValue;
    }

    public Double getNominalValue() {
        return nominalValue;
    }

    public Integer getResidualMaturity() {
        return residualMaturity;
    }

    public Boolean getOptionWriterPosition() {
        return optionWriterPosition;
    }

    public Boolean getBasisSwap() {
        return basisSwap;
    }

    public Boolean getCvaHedge() {
        return cvaHedge;
    }

    public Integer getReferencedCounterpartyId() {
        return referencedCounterpartyId;
    }

    public IntermediateResultsTransaction getIntermediateResultsTransaction() {
        return intermediateResultsTransaction;
    }

    public int getInputCounterpartyId() {
        return inputCounterparty.getId();
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setInputCounterparty(InputCounterparty inputCounterparty) {
        this.inputCounterparty = inputCounterparty;
    }

    public void setNettingSetId(Integer nettingSetId) {
        this.nettingSetId = nettingSetId;
    }

    public void setCategory(TransactionCategories category) {
        this.category = category;
    }

    public void setCurrentMarketValue(Double currentMarketValue) {
        this.currentMarketValue = currentMarketValue;
    }

    public void setNominalValue(Double nominalValue) {
        this.nominalValue = nominalValue;
    }

    public void setResidualMaturity(Integer residualMaturity) {
        this.residualMaturity = residualMaturity;
    }

    public void setOptionWriterPosition(Boolean optionWriterPosition) {
        this.optionWriterPosition = optionWriterPosition;
    }

    public void setBasisSwap(Boolean basisSwap) {
        this.basisSwap = basisSwap;
    }

    public void setCvaHedge(Boolean cvaHedge) {
        this.cvaHedge = cvaHedge;
    }

    public void setReferencedCounterpartyId(Integer referencedCounterpartyId) {
        this.referencedCounterpartyId = referencedCounterpartyId;
    }

    public void setIntermediateResultsTransaction(IntermediateResultsTransaction intermediateResultsTransaction) {
        this.intermediateResultsTransaction = intermediateResultsTransaction;
    }


}
