package ProblemStatement61;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Stock {
    private String symbol;
    private double price;
    private int units;

    public Stock(String symbol, double price, int units) {
        this.symbol = symbol;
        this.price = price;
        this.units = units;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public int getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return "Stock [symbol=" + symbol + ", price=" + price + ", units=" + units + "]";
    }
}

class StockFilters {
    public static List<Stock> filter(List<Stock> stocks, Predicate<Stock> predicate) {
        List<Stock> filteredStocks = new ArrayList<>();
        for (Stock stock : stocks) {
            if (predicate.test(stock)) {
                filteredStocks.add(stock);
            }
        }
        return filteredStocks;
    }
}
