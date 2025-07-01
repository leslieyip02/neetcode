class Solution {
    public int maxProfit(int[] prices) {
        int lowest = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(prices[i] - lowest, profit);
            lowest = Math.min(prices[i], lowest);
        }
        return profit;
    }
}

