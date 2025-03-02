package io.github.snoozy10.softwarepatterns;

import java.util.ArrayList;
import java.util.List;

// Concrete Subject (Stock)
class CompanyStock implements Stock {
    private List<Investor> investors;
    private String stockSymbol;
    private double stockPrice;

    public CompanyStock(String stockSymbol, double stockPrice) {
        this.stockSymbol = stockSymbol;
        this.stockPrice = stockPrice;
        this.investors = new ArrayList<>();
    }

    @Override
    public void addInvestor(Investor investor) {
        investors.add(investor);
    }

    @Override
    public void removeInvestor(Investor investor) {
        investors.remove(investor);
    }

    @Override
    public void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(stockSymbol, stockPrice);
        }
    }

    // Method to update stock price
    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        System.out.println("\nStock Update: " + stockSymbol + " new price: $" + stockPrice);
        notifyInvestors();
    }
}
