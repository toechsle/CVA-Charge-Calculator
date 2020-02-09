package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsSandPShortTerm {

    Aminus1plus("A-1+"),
    Aminus1("A-1"),
    Aminus2("A-2"),
    Aminus3("A-3"),
    B("B"),
    C("C");

    private String value;
    RatingsSandPShortTerm(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    private static final Map<String, RatingsSandPShortTerm> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsSandPShortTerm rating : RatingsSandPShortTerm.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsSandPShortTerm fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }


}
