package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsSandPFundCreditQualityRatingsCIU {

    AAA_f("AAA f"),
    AAplus_f("AA+ f"),
    AA_f("AA f"),
    AAminus_f("AA- f"),
    Aplus_f("A+ f"),
    A_f("A f"),
    Aminus_f("A- f"),
    BBBplus_f("BBB+ f"),
    BBB_f("BBB f"),
    BBBminus_f("BBB- f"),
    BBplus_f("BB+ f"),
    BB_f("BB f"),
    BBminus_f("BB- f"),
    Bplus_f("B+ f"),
    B_f("B f"),
    Bminus_f("B- f"),
    CCCplus_f("CCC+ f"),
    CCC_f("CCC f"),
    CCCminus_f("CCC- f"),
    CC_f("CC f"),
    C_f("C f"),
    D_f("D f");

    private String value;
    RatingsSandPFundCreditQualityRatingsCIU(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    private static final Map<String, RatingsSandPFundCreditQualityRatingsCIU> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsSandPFundCreditQualityRatingsCIU rating : RatingsSandPFundCreditQualityRatingsCIU.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsSandPFundCreditQualityRatingsCIU fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }



}
