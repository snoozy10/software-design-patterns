package io.github.snoozy10.softwarepatterns;

// Legacy payment gateway (GooglePay) with a different interface
class PaymentGooglePay {
    public void payUsd(double usdAmount) {
        System.out.println("Paying " + usdAmount + " " + "USD" + " successful!");
    }
}
