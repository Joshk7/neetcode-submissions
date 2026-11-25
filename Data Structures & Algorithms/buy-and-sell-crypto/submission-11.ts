class Solution {
    /**
     * @param {number[]} prices
     * @return {number}
     */
    maxProfit(prices: number[]): number {
        let profit = 0, n = prices.length;
        for (let i = 0; i < n; i++) {
            for (let j = i + 1; j < n; j++) {
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }
        return profit;
    }
}
