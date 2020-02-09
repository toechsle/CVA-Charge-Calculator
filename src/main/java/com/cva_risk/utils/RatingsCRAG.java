package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsCRAG {

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
    C("C"),
    D("D");

    private String value;
    RatingsCRAG(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    private static final Map<String, RatingsCRAG> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsCRAG rating : RatingsCRAG.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsCRAG fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }




}
