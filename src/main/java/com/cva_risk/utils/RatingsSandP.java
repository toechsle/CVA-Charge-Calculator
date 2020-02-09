package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsSandP {

    AAA("AAA"),
    AAplus("AA+"),
    AA("AA"),
    AAminus("AA-"),
    Aplus("A+"),
    A("A"),
    Aminus("A-"),
    BBBplus("BBB+"),
    BBB("BBB"),
    BBBminus("BBB-"),
    BBplus("BB+"),
    BB("BB"),
    BBminus("BB-"),
    Bplus("B+"),
    B("B"),
    Bminus("B-"),
    CCCplus("CCC+"),
    CCC("CCC"),
    CCCminus("CCC-"),
    CC("CC"),
    C("C"),
    D("D");

    private String value;
    RatingsSandP(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    private static final Map<String, RatingsSandP> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsSandP rating : RatingsSandP.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsSandP fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }




}
