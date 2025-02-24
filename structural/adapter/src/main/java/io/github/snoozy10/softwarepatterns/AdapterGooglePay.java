package io.github.snoozy10.softwarepatterns;

// Adapter class to wrap around legacy code
class AdapterGooglePay implements PaymentProcessor {
    private PaymentGooglePay googlePay;

    public AdapterGooglePay(PaymentGooglePay googlePay) {
        this.googlePay = googlePay;
    }

    @Override
    public void processPayment(double amount, String currency) {
        double convertedAmount = AdapterUtilClass.convert(amount, currency, "USD");
        googlePay.payUsd(convertedAmount);
        System.out.println("[GPAY ADAPTER] Processing payment of " + amount + " " + currency + " successful.");
    }
}
