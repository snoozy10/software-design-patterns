package io.github.snoozy10.softwarepatterns;

// Main class to test the observer pattern
public class Main {
    public static void main(String[] args) {
        CompanyStock appleStock = new CompanyStock("AAPL", 150.00);

        RetailInvestor john = new RetailInvestor("John Doe");
        InstitutionalInvestor goldmanSachs = new InstitutionalInvestor("Goldman Sachs");

        // Adding investors to observe stock updates
        appleStock.addInvestor(john);
        appleStock.addInvestor(goldmanSachs);

        // Stock price updates
        appleStock.setStockPrice(155.50);
        appleStock.setStockPrice(160.75);

        // Removing an investor and updating price
        appleStock.removeInvestor(john);
        appleStock.setStockPrice(165.00);
    }
}
