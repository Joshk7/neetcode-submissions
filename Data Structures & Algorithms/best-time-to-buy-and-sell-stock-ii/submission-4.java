class Solution {
    public int maxProfit(int[] prices) {
        // int n = prices.length;
        // int[][] dp = new int[n + 1][2];
        // for (int i = n - 1; i >= 0; i--) {
        //     dp[i][0] = Math.max(dp[i + 1][0], -prices[i] + dp[i + 1][1]);
        //     dp[i][1] = Math.max(dp[i + 1][1], prices[i] + dp[i + 1][0]);
        // }

        // return dp[0][0];

        int nextBuy = 0, nextSell = 0;
        int curBuy = 0, curSell = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            curBuy = Math.max(nextBuy, -prices[i] + nextSell);
            curSell = Math.max(nextSell, prices[i] + nextBuy);
            nextBuy = curBuy;
            nextSell = curSell;
        }
        
        return curBuy;
    }
}