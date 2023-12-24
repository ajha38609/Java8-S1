package ProblemStatement62;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StockFilterApp2 {

	public static void main(String[] args) {
		// Create a list of stocks
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("AAPL", 350.0, 100));
        stocks.add(new Stock("GOOGL", 1200.0, 50));
        stocks.add(new Stock("AMZN", 2000.0, 75));

    // Use Lambda expression to define the predicate for filtering by price above 300
        Predicate<Stock> priceAbove300 = stock -> stock.getPrice() > 300;

        // Use the generic filter method with the priceAbove300 predicate
        List<Stock> filteredStocks = StockFilters.filter(stocks, priceAbove300);

        // Print the filtered stocks
        filteredStocks.forEach(System.out::println);
	}

}

