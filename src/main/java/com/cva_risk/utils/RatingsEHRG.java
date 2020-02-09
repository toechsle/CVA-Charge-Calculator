package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsEHRG {

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
    CCC("CCC"),
    CC("CC"),
    C("C");

    private String value;
    RatingsEHRG(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    private static final Map<String, RatingsEHRG> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsEHRG rating : RatingsEHRG.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsEHRG fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }




}
