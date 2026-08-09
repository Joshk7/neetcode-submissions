class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minimum = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minimum) {
                minimum = prices[i];
            } else if (prices[i] - minimum > profit) {
                profit = prices[i] - minimum;
            }
        }
        return profit;
    }
}
