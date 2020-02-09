package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum RatingsFitchShortTerm {

    F1plus("F1+"),
    F1("F1"),
    F2("F2"),
    F3("F3"),
    B("B"),
    C("C");

    private String value;
    RatingsFitchShortTerm(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    private static final Map<String, RatingsFitchShortTerm> stringToRatingMap = new HashMap<>();
    static {
        for (RatingsFitchShortTerm rating : RatingsFitchShortTerm.values()) {
            stringToRatingMap.put(rating.value, rating);
        }
    }

    public static RatingsFitchShortTerm fromString(String ratingString) {
        return stringToRatingMap.get(ratingString);
    }


}
