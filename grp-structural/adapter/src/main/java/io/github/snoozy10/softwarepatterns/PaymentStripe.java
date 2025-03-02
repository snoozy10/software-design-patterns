package io.github.snoozy10.softwarepatterns;

// up-to-date service from Stripe, no adapter needed
class PaymentStripe implements PaymentProcessor {
    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("[STRIPE] Processing payment of " + amount + " " + currency + " successful.");
    }
}
