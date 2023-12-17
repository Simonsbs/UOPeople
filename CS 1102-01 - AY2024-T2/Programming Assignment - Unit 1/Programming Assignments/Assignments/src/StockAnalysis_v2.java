// StockAnalysis_v2.java

import java.util.ArrayList;
import java.util.Random;

/**
 * This class provides methods to analyze stock prices,
 * including:
 * 1. Calculating average price
 * 2. Finding maximum price
 * 3. Counting occurrences of a specific price
 * 4. Computing cumulative sums
 */
public class StockAnalysis_v2 {
    // Length of the stock prices array
    private final static int STOCK_DATA_LENGTH = 10;

    /**
     * Main entry point
     * Builds the array of demo stock prices and calls the methods to analyze them.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Random generator for stock prices
        Random random = new Random();

        // Creating an array of random stock prices
        float[] stockPrices = new float[STOCK_DATA_LENGTH]; // Array of randomly generated stock prices
        for (int i = 0; i < stockPrices.length; i++) {
            // Generating a random value between 100.0 and 200.0
            stockPrices[i] = 100.0f + random.nextFloat() * 100.0f;
        }

        // Print out the randomly generated stock prices for reference
        System.out.print("Generated Stock Prices: ");
        int i = 0;
        while (i < stockPrices.length) {
            System.out.print(stockPrices[i] + " | ");
            i++;
        }
        System.out.println();

        // Displaying the average stock price
        float average = calculateAvgStockPrice(stockPrices);
        System.out.println("Average Stock Price: " + average);

        // Displaying the maximum stock price
        float maximum = findMaxStockPrice(stockPrices);
        System.out.println("Maximum Stock Price: " + maximum);

        // Pick a random value from the generated stock prices to use as the target
        // price for counting occurrences
        float targetPrice = stockPrices[random.nextInt(stockPrices.length)];

        // Counting occurrences of a specific price
        int occurrences = countPriceOccurrences(targetPrice, stockPrices);
        System.out.println("Occurrences of " + targetPrice + ": " + occurrences);

        // Converting the array of stock prices to an ArrayList
        ArrayList<Float> stockPricesList = convertArrayToArrayList(stockPrices);

        // Displaying the cumulative sum of stock prices
        ArrayList<Float> cumulativeSum = calculateCumulativeSum(stockPricesList);
        System.out.println("Cumulative Sums: " + cumulativeSum);
    }

    /**
     * Converts an array of floats to an ArrayList of floats.
     *
     * @param floatArray The array of floats to be converted.
     * @return An ArrayList containing the elements of the given float array.
     */
    public static ArrayList<Float> convertArrayToArrayList(float[] floatArray) {
        ArrayList<Float> floatList = new ArrayList<>();
        for (float value : floatArray) {
            floatList.add(value);
        }
        return floatList;
    }

    /**
     * Calculates the average based on an array of stock prices.
     * This method uses a traditional for loop.
     *
     * @param stockList The array of stock prices.
     * @return The average price of the stock prices.
     */
    public static float calculateAvgStockPrice(float[] stockArray) {
        // Create and initialize a local variable to store the running total
        float result = 0;

        // Iterate through the given array of stock prices using a traditional for loop
        for (int i = 0; i < stockArray.length; i++) {
            // Add the current stock price to the running total
            result += stockArray[i];
        }
        // Return the average of the stock prices by taking the running total and
        // dividing by the length of the given array
        return result / stockArray.length;
    }

    /**
     * Finds the highest value in an array of stock prices.
     * This method uses a do-while loop even though it might not be the most
     * efficient method to do so.
     * Since we are using a do-while loop, we need to check if the array is empty
     * to avoid running into an IndexOutOfBoundsException.
     *
     * @param stockArray The array of stock prices.
     * @return The highest stock price.
     */
    public static float findMaxStockPrice(float[] stockArray) {
        // Check if the array is empty to avoid IndexOutOfBoundsException
        if (stockArray == null || stockArray.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        // Create and initialize a local variable to store the highest value
        float max = stockArray[0];

        // Iterate through the given array of stock prices using a traditional for loop
        int i = 1;
        do {
            // Check if the current stock price is higher than the highest value
            if (stockArray[i] > max) {
                // If so, update the highest value
                max = stockArray[i];
            }
            i++;
        } while (i < stockArray.length);

        // Return the highest value
        return max;
    }

    /**
     * Counts how many times a specific price occurs in an array of stock prices.
     * This method uses a classic for loop to iterate through the array.
     *
     * @param lookingForValue The specific price to count.
     * @param stockArray      The array of stock prices.
     * @return The count of the specific price.
     */
    public static int countPriceOccurrences(float lookingForValue, float[] stockArray) {
        int count = 0;
        for (int i = 0; i < stockArray.length; i++) {
            if (stockArray[i] == lookingForValue) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculates the cumulative sum of an ArrayList of stock prices.
     * This method uses an for..each style loop to iterate through the ArrayList.
     *
     * @param stockList The ArrayList of stock prices.
     * @return An ArrayList representing the cumulative sum.
     */
    public static ArrayList<Float> calculateCumulativeSum(ArrayList<Float> stockList) {
        ArrayList<Float> resultList = new ArrayList<>();
        float runningSum = 0;
        for (float stock : stockList) {
            runningSum += stock;
            resultList.add(runningSum);
        }
        return resultList;
    }
}
