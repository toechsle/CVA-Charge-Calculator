package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsDBRS {

    AAA("AAA"),
    AAhigh("AAhigh"),
    AA("AA"),
    AAlow("AAlow"),
    Ahigh("Ahigh"),
    A("A"),
    Alow("Alow"),
    BBBhigh("BBBhigh"),
    BBB("BBB"),
    BBBlow("BBBlow"),
    BBhigh("BBhigh"),
    BB("BB"),
    BBlow("BBlow"),
    Bhigh("Bhigh"),
    B("B"),
    Blow("Blow"),
    CCC("CCC"),
    CC("CC"),
    C("C"),
    D("D");

    private String value;
    RatingsDBRS(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    private static final Map<String, RatingsDBRS> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsDBRS rating : RatingsDBRS.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsDBRS fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }



}
