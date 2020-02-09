package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsSandPPrincipalStabilityFundRatingsCIU {

    AAA_m("AAA m"),
    AAplus_m("AA+ m"),
    AA_m("AA m"),
    AAminus_m("AA- m"),
    Aplus_m("A+ m"),
    A_m("A m"),
    Aminus_m("A- m"),
    BBBplus_m("BBB+ m"),
    BBB_m("BBB m"),
    BBBminus_m("BBB- m"),
    BBplus_m("BB+ m"),
    BB_m("BB m"),
    BBminus_m("BB- m"),
    Bplus_m("B+ m"),
    B_m("B m"),
    Bminus_m("B- m"),
    CCCplus_m("CCC+ m"),
    CCC_m("CCC m"),
    CCCminus_m("CCC- m"),
    CC_m("CC m"),
    C_m("C m"),
    D_m("D m");

    private String value;
    RatingsSandPPrincipalStabilityFundRatingsCIU(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    private static final Map<String, RatingsSandPPrincipalStabilityFundRatingsCIU> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsSandPPrincipalStabilityFundRatingsCIU rating : RatingsSandPPrincipalStabilityFundRatingsCIU.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsSandPPrincipalStabilityFundRatingsCIU fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }



}
