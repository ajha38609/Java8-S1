package ProblemStatement6;

import java.util.ArrayList;
import java.util.List;

public class StockFilterApp {

	public static void main(String[] args) {
		List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("AAPL", 150.0, 100));
        stocks.add(new Stock("GOOGL", 2500.0, 50));
        stocks.add(new Stock("MSFT", 300.0, 75));

        // Print all stocks using forEach and Method Reference
        stocks.forEach(System.out::println);

        // Example of filtering stocks using predicates
        List<Stock> filteredBySymbol = StockFilters.filter(stocks, StockFilters.bySymbol("AAPL"));
        System.out.println("\nStocks filtered by symbol (AAPL):");
        filteredBySymbol.forEach(System.out::println);

        List<Stock> filteredByPriceAbove = StockFilters.filter(stocks, StockFilters.byPriceAbove(200.0));
        System.out.println("\nStocks filtered by price above $200.0:");
        filteredByPriceAbove.forEach(System.out::println);

	}

}


