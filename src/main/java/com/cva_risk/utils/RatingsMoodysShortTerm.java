package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsMoodysShortTerm {

    Pminus1("P-1"),
    Pminus2("P-2"),
    Pminus3("P-3"),
    NP("NP");

    private String value;
    RatingsMoodysShortTerm(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    private static final Map<String, RatingsMoodysShortTerm> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsMoodysShortTerm rating : RatingsMoodysShortTerm.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsMoodysShortTerm fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }


}
