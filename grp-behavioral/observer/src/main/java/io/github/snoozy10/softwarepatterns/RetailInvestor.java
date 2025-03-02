package io.github.snoozy10.softwarepatterns;

// Concrete Observer 1 (Retail Investor)
class RetailInvestor implements Investor {
    private String investorName;

    public RetailInvestor(String investorName) {
        this.investorName = investorName;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println(investorName + " received update - " + stockSymbol + ": $" + stockPrice);
    }
}
