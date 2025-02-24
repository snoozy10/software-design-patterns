package io.github.snoozy10.softwarepatterns;

public interface PaymentProcessor {
    void processPayment(double amount, String currency);
}
