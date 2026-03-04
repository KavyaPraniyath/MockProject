package problems.interview.block;

import java.util.HashMap;
import java.util.Map;

class Node {
    double price;
    String stockName;
    public Node (double price, String stockName) {
        this.price = price;
        this.stockName = stockName;
    }
}
public class StockService {
    Map<String, Node> stockDetails;

    public StockService() {
        stockDetails = new HashMap<>();
    }
    public void insertStock(String stockName, String timestamp, double price) {
        Node node = new Node(price, stockName);
        stockDetails.put(timestamp, node);
    }

    public double getPrice(String timestamp) {
        if (stockDetails.containsKey(timestamp)) {
            return stockDetails.get(timestamp).price;
        }
        return 0.0;
    }

    public double getPrice(String timestamp, String stockName) {
        if (stockDetails.containsKey(timestamp)) {
            Node node = stockDetails.get(timestamp);
            if (stockName.equals(node.stockName)) {
                return stockDetails.get(timestamp).price;
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    public String getPercentagePriceChange(String startTimestamp, String endTimestamp) {
        double startPrice = getPrice(startTimestamp);
        double endPrice = getPrice(endTimestamp);
        if(startPrice < 0) {
            return String.format("+ %.2f", 0);
        }
        double result = ((endPrice - startPrice) / startPrice) * 100;
        if (result >= 0.0) {
            return String.format("+ %.2f", result);
        }
        return String.format("- %.2f", Math.abs(result));

    }

    public static void main(String[] args) {
        /**
         * "SQ", "2020-01-01", 2500
         * "SQ", "2020-01-02", 2600
         * "SQ", "2020-01-03", 2400
         * "SQ", "2020-01-04", 2200
         * "SQ", "2020-01-05", 2400
         * "SQ", "2020-01-06", 2100
         * "SQ", "2020-01-07", 2000
         * "SQ", "2020-01-08", 2800
         * "SQ", "2020-01-09", 2700
         * "SQ", "2020-01-10", 2200
         */
        StockService stockService = new StockService();
        stockService.insertStock("SQ", "2020-01-01", 2500);
        stockService.insertStock("SQ", "2020-01-02", 2600);
        stockService.insertStock("SQ", "2020-01-03", 2400);
        stockService.insertStock("SQ", "2020-01-04", 2200);
        stockService.insertStock("SQ", "2020-01-05", 2400);
        stockService.insertStock("SQ", "2020-01-06", 2100);
        stockService.insertStock("SQ", "2020-01-07", 2000);
        stockService.insertStock("SQ", "2020-01-08", 2800);
        stockService.insertStock("SQ", "2020-01-09", 2700);
        stockService.insertStock("SQ", "2020-01-10", 2200);
        System.out.println("Price for timestamp 2020-01-04 is: " + stockService.getPrice("2020-01-04"));
        System.out.println("Price for timestamp 2020-01-04 is: " + stockService.getPrice("2020-01-08"));
        System.out.println("Percentage Change: " + stockService.getPercentagePriceChange("2020-01-07", "2020-01-10") +"%");
        System.out.println("Percentage Change: " + stockService.getPercentagePriceChange("2020-01-01", "2020-01-10") + "%");
        System.out.println("Percentage Change: " + stockService.getPercentagePriceChange("2020-01-05", "2020-01-05") + "%");

        /**
         * "AAPL", "2020-01-01", 5500
         * "AAPL", "2020-01-02", 5300
         * "AAPL", "2020-01-03", 5400
         * "AAPL", "2020-01-04", 4800
         * "AAPL", "2020-01-05", 4200
         * "AAPL", "2020-01-06", 4900
         * "AAPL", "2020-01-07", 6300
         * "AAPL", "2020-01-08", 5100
         * "AAPL", "2020-01-09", 6100
         * "AAPL", "2020-01-10", 6800
         */

        stockService.insertStock("AAPL", "2020-01-04", 4800);
        stockService.insertStock("AAPL", "2020-01-05", 4200);
        System.out.println("Price for timestamp 2020-01-04 and AAPL is: " + stockService.getPrice("2020-01-05", "AAPL"));
        System.out.println("Price for timestamp 2020-01-04 and AAPL is: " + stockService.getPrice("2020-01-10", "AAPL"));

    }
}
