package io.github.snoozy10.softwarepatterns;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor stripe = new PaymentStripe();
        PaymentProcessor paypalAdapter = new AdapterPayPal(new PaymentPayPal());
        PaymentProcessor googlePayAdapter = new AdapterGooglePay(new PaymentGooglePay());
        // stripe is up-to-date with service methods
        stripe.processPayment(100, "EUR");
        // older systems like paypal and gpay need to go through adapters
        paypalAdapter.processPayment(1200, "GBP"); // Note: Large transactions triggers security check
        googlePayAdapter.processPayment(500, "USD");
    }
}
