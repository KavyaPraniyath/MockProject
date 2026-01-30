package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC2034StockPriceFluctuation {
    Map<Integer, Integer> record;//Store the timestamp and price
    TreeMap<Integer, Integer> prices; //store the price and occurances
    int latestTime = 0;

    public LC2034StockPriceFluctuation() {
        record = new HashMap<>();
        prices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (record.containsKey(timestamp)) {
            int prevPrice = record.get(timestamp);
            prices.put(prevPrice, prices.get(prevPrice) - 1);
            if (prices.get(prevPrice) == 0) {
                prices.remove(prevPrice);
            }
        }
        record.put(timestamp, price);
        prices.put(price, prices.getOrDefault(price, 0) + 1);
        latestTime = Math.max(latestTime, timestamp);
    }

    public int current() {
        return record.get(latestTime);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }

    public static void main(String[] args) {
        LC2034StockPriceFluctuation lc2034 = new LC2034StockPriceFluctuation();
        lc2034.update(1, 10);
        lc2034.update(2, 5);
        System.out.println(lc2034.current());
        System.out.println(lc2034.maximum());
        lc2034.update(1, 3);
        System.out.println(lc2034.maximum());
        System.out.println(lc2034.minimum());
    }
}
