// StockAnalysis.java

import java.util.ArrayList;

/**
 * This class provides methods to analyze stock prices,
 * including:
 * 1. Calculating average price
 * 2. Finding maximum price
 * 3. Counting occurrences of a specific price
 * 4. Computing cumulative sums
 */
public class StockAnalysis {

    /**
     * Main method to demonstrate the functionality of the methods
     * and display them to the user in the console.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Demo data for array
        float[] stockPricesArray = { 100f, 150f, 200f, 250f, 300f, 350f, 400f, 450f, 500f, 550f };

        // Convert array to ArrayList by copying each element
        ArrayList<Float> stockPricesArrayList = new ArrayList<>();
        for (float price : stockPricesArray) {
            stockPricesArrayList.add(price);
        }

        // Demonstrate calculateAveragePrice method
        float averagePrice = calculateAveragePrice(stockPricesArray);
        System.out.println("Average Stock Price: " + averagePrice);

        // Demonstrate findMaximumPrice method
        float maxPrice = findMaximumPrice(stockPricesArray);
        System.out.println("Maximum Stock Price: " + maxPrice);

        // Demonstrate countOccurrences method with a target price of 300
        float targetPrice = 300f;
        int occurrenceCount = countOccurrences(stockPricesArray, targetPrice);
        System.out.println("Occurrences of price " + targetPrice + ": " + occurrenceCount);

        // Demonstrate computeCumulativeSum method
        ArrayList<Float> cumulativeSums = computeCumulativeSum(stockPricesArrayList);
        System.out.println("Cumulative Sums: " + cumulativeSums);
    }

    /**
     * Calculate the average price of stocks.
     * 
     * @param prices Array of stock prices.
     * @return Average stock price.
     */
    public static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    /**
     * Find the maximum price among the stocks.
     * 
     * @param prices Array of stock prices.
     * @return Maximum stock price.
     */
    public static float findMaximumPrice(float[] prices) {
        float maxPrice = prices[0];
        for (float price : prices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    /**
     * Count the occurrence of a specific price.
     * 
     * @param prices      Array of stock prices.
     * @param targetPrice Target price to count occurrences of.
     * @return Count of occurrences of the target price.
     */
    public static int countOccurrences(float[] prices, float targetPrice) {
        int count = 0;
        for (float price : prices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    /**
     * Compute the cumulative sum of stock prices.
     * 
     * @param prices ArrayList of stock prices.
     * @return ArrayList containing cumulative sums.
     */
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulativeSums = new ArrayList<>();
        float sum = 0;
        for (float price : prices) {
            sum += price;
            cumulativeSums.add(sum);
        }
        return cumulativeSums;
    }
}
