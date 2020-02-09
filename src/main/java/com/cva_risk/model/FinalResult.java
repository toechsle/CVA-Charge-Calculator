package com.cva_risk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FinalResult")
public class FinalResult {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="value")
    private Double value;


    public FinalResult() {

    }


    public int getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
