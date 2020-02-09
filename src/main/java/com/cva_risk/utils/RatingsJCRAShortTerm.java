package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsJCRAShortTerm {

    Jminus1plus("J-1+"),
    Jminus1("J-1"),
    Jminus2("J-2"),
    Jminus3("J-3"),
    NJ("NJ");

    private String value;
    RatingsJCRAShortTerm(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    private static final Map<String, RatingsJCRAShortTerm> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsJCRAShortTerm rating : RatingsJCRAShortTerm.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsJCRAShortTerm fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }





}
