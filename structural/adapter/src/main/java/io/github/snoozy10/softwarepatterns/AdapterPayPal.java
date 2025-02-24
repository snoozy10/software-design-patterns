package io.github.snoozy10.softwarepatterns;

// Adapter class for PayPal to wrap around legacy code. Legacy system can only handle dollar amounts
class AdapterPayPal implements PaymentProcessor {
    private PaymentPayPal paypal;

    public AdapterPayPal(PaymentPayPal paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount, String currency) {
        double convertedAmount = AdapterUtilClass.convert(amount, currency, "USD");
        securityCheck(convertedAmount);

        boolean legacyCodeResponse = paypal.sendPayment(convertedAmount);
        if(legacyCodeResponse) {
            System.out.println("[PAYPAL ADAPTER] Processing payment of " + amount + " " + currency + " successful.");
        }
    }

    private void securityCheck(double amount) {
        if (amount > 1000) {
            System.out.println("[PAYPAL SECURITY] Large transaction (>1000 USD) detected! Additional verification required.");
        }
    }
}
