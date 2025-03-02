package io.github.snoozy10.softwarepatterns;

// Subject Interface
interface Stock {
    void addInvestor(Investor investor);

    void removeInvestor(Investor investor);

    void notifyInvestors();
}
