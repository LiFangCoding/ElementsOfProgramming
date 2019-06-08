package _6_Arrays;

import java.util.List;

/**
 * Write a program that takes an array denoting that daily stock price and returns the maximum profit that could
 * be made by buying and then selling one share of that stock.
 */
public class _6_BuyAndSellStockOnce {
    // Hint: Identifying the minimum and maximum is not enough since the minimum may appear after the maximum height.
    // Focus on valid differences.

    /**
     * Compute the difference of the current entry with the minimum value seen so far as we iterate through the array.
     * <p>
     * For example, the array of minimum value seen so far for [310,315,275,295,260,270,290,230,255,250] is
     * [310, 310, 275, 275, 260, 260, 260, 230, 230, 230]. The maximum profit that can be made by selling on each day is
     * the difference of current price and minimum so far. [0,5,0,20,0,10,30,0,25,20].
     * <p>
     * T = O(n)
     * S = O(1)
     */
    public static double computeMaxProfit(List<Double> prices) {
        double minPrice = Double.MAX_VALUE, maxProfit = 0.0;

        for (double price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }
}
