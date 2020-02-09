package com.cva_risk.model;

import javax.persistence.*;


@Entity
@Table(name="InputCollaterals")
public class InputCollateral {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="net_collateral_received")
    private Double netCollateralReceived;


    public InputCollateral() {

    }


    public int getId() {
        return id;
    }

    public Double getNetCollateralReceived() {
        return netCollateralReceived;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNetCollateralReceived(Double netCollateralReceived) {
        this.netCollateralReceived = netCollateralReceived;
    }

}
