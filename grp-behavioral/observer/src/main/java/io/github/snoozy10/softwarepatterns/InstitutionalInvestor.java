package io.github.snoozy10.softwarepatterns;

// Concrete Observer 2 (Institutional Investor)
class InstitutionalInvestor implements Investor {
    private String investorCompany;

    public InstitutionalInvestor(String investorCompany) {
        this.investorCompany = investorCompany;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("Institutional Investor (" + investorCompany + ") received update - "
                + stockSymbol + ": $" + stockPrice);
    }
}
