package com.leetcode.arrays;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.
 * <p>
 * Find and return the maximum profit you can achieve.
 */
public class BuySellStock2 {

    public static void main(String[] args) {
        BuySellStock2 buySellStock = new BuySellStock2();
        System.out.println(buySellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(buySellStock.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < currentMin) {
                currentMin = prices[i];
            } else {
                maxProfit += prices[i] - currentMin;
                currentMin = prices[i];
            }
        }
        return maxProfit;
    }
}
