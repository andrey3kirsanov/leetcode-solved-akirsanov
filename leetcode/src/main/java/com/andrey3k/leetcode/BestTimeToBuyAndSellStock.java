package com.andrey3k.leetcode;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int min = 10000;

		int maxDiff = 0;

		for (int i = 0; i < prices.length; i++) {
			min = Math.min(prices[i], min);

			maxDiff = Math.max(prices[i] - min, maxDiff);
		}
		return maxDiff;
	}
}
