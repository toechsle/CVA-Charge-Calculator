package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsFitchCIU {

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
    DDD("DDD"),
    DD("DD"),
    D("D");

    private String value;
    RatingsFitchCIU(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return this.value;
    }

    private static final Map<String, RatingsFitchCIU> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsFitchCIU rating : RatingsFitchCIU.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsFitchCIU fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }



}
