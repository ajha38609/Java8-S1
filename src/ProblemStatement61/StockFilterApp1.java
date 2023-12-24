package ProblemStatement61;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StockFilterApp1 {

	public static void main(String[] args) {
		List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("AMZ", 2000.0, 10));
        stocks.add(new Stock("AAPL", 150.0, 20));
        stocks.add(new Stock("GOOGL", 3000.0, 5));

        // Lambda expression for filtering stocks by symbol
        Predicate<Stock> bySymbol = stock -> "AMZ".equals(stock.getSymbol());

        // Filter and print stocks with symbol "AMZ"
        List<Stock> filteredStocks = StockFilters.filter(stocks, bySymbol);
        for (Stock stock : filteredStocks) {
            System.out.println(stock);
        }
	}
}
