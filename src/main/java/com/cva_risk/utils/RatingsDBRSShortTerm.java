package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsDBRSShortTerm {

    Rminus1_high("R-1 (high)"),
    Rminus1_middle("R-1 (middle)"),
    Rminus1_low("R-1 (low)"),
    Rminus2_high("R-2 (high)"),
    Rminus2_middle("R-2 (middle)"),
    Rminus2_low("R-2 (low)"),
    Rminus3("R-3"),
    Rminus4("R-4"),
    Rminus5("R-5"),
    D("D");

    private String value;
    RatingsDBRSShortTerm(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    private static final Map<String, RatingsDBRSShortTerm> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsDBRSShortTerm rating : RatingsDBRSShortTerm.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsDBRSShortTerm fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }

}
