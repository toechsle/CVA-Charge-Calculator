package com.cva_risk.utils;

import java.util.HashMap;
import java.util.Map;

public enum TransactionCategories {

    interestRateContracts("Interest Rate Contracts"),
    contractsConcerningForeignExchangeRatesAndGold("Contracts Concerning Foreign Exchange Rates And Gold"),
    contractsConcerningEquities("Contracts Concerning Equities"),
    contractsConcerningPreciousMetalsExceptGold("Contracts Concerning Precious Metals Except Gold"),
    contractsConcerningCommoditiesOtherThanPreciousMetals("Contracts Concerning Commodities Other Than Precious Metals"),
    otherContracts("Other Contracts");


    private String value;
    TransactionCategories(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


    private static final Map<String, TransactionCategories> stringToCategoryMap = new HashMap<>();
    static {
        for (TransactionCategories category : TransactionCategories.values()) {
            stringToCategoryMap.put(category.value, category);
        }
    }

    public static TransactionCategories fromString(String categoryString) {
        return stringToCategoryMap.get(categoryString);
    }


}
