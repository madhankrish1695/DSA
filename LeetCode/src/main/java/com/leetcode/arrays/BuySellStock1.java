package com.leetcode.arrays;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.
 * <p>
 * Find and return the maximum profit you can achieve.
 */
public class BuySellStock1 {

    public static void main(String[] args) {
        BuySellStock1 buySellStock = new BuySellStock1();
        System.out.println(buySellStock.maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(buySellStock.maxProfit1(new int[]{7, 6, 4, 3, 1}));
        System.out.println(buySellStock.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(buySellStock.maxProfit2(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (minValue > prices[i]) {
                minValue = prices[i];
                maxValue = Integer.MIN_VALUE;
            } else if (maxValue < prices[i]) {
                maxValue = prices[i];
                maxProfit = Math.max(maxProfit, maxValue - minValue);
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (minValue > prices[i]) {
                minValue = prices[i];
            } else if (maxProfit < prices[i] - minValue) {
                maxProfit = prices[i] - minValue;
            }
        }
        return maxProfit;
    }
}
