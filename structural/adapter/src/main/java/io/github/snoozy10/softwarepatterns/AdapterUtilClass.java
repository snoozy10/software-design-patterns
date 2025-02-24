package io.github.snoozy10.softwarepatterns;

import java.util.HashMap;
import java.util.Map;

class AdapterUtilClass {
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("GBP", 0.80);
    }

    public static double convert(double amount, String fromCurrency, String toCurrency) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Unsupported currency: " + fromCurrency + " or " + toCurrency);
        }
        double usdAmount = amount / exchangeRates.get(fromCurrency); // Convert to USD first
        return usdAmount * exchangeRates.get(toCurrency); // Convert to target currency
    }
}
