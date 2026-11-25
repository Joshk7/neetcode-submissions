class Solution {
    /**
     * @param {number[]} prices
     * @return {number}
     */
    maxProfit(prices: number[]): number {
        let profit = 0,
            l = 0,
            r = 0,
            n = prices.length;
        
        while (r < n) {
            if (prices[r] - prices[l] < 0) {
                l = r;
            } else {
                profit = Math.max(profit, prices[r] - prices[l]);
            }
            r++;
        }

        return profit;
    }
}
