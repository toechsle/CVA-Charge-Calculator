package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsMoodys {

    Aaa("Aaa"),
    Aa1("Aa1"),
    Aa2("Aa2"),
    Aa3("Aa3"),
    A1("A1"),
    A2("A2"),
    A3("A3"),
    Baa1("Baa1"),
    Baa2("Baa2"),
    Baa3("Baa3"),
    Ba1("Ba1"),
    Ba2("Ba2"),
    Ba3("Ba3"),
    B1("B1"),
    B2("B2"),
    B3("B3"),
    Caa1("Caa1"),
    Caa2("Caa2"),
    Caa3("Caa3"),
    Ca("Ca"),
    C("C");

    private String value;
    RatingsMoodys(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    private static final Map<String, RatingsMoodys> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsMoodys rating : RatingsMoodys.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsMoodys fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }


}
