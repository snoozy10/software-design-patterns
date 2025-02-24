package io.github.snoozy10.softwarepatterns;

// Legacy payment gateway (PayPal) with a different interface
class PaymentPayPal {
    public boolean sendPayment(double amount) {
        System.out.println("Your payment of " + amount + " " + "USD" + " was successful!");
        return true;
    }
}
