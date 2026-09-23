class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = Math.max(dp[i + 1][0], -prices[i] + dp[i + 1][1]);
            dp[i][1] = Math.max(dp[i + 1][1], prices[i] + dp[i + 1][0]);
        }

        return dp[0][0];

        // int n = prices.length;
        // int[][] dp = new int[n][2];
        // for (int i = 0; i < n; i++) {
        //     dp[i][0] = -1;
        //     dp[i][1] = -1;
        // }
        // return rec(prices, 0, 0, dp);
    }

    // private int rec(int[] prices, int i, int bought, int[][] dp) {
    //     if (i == prices.length) {
    //         return 0;
    //     }

    //     if (dp[i][bought] != -1) {
    //         return dp[i][bought];
    //     }

    //     int res = rec(prices, i + 1, bought, dp);
    //     if (bought == 1) {
    //         res = Math.max(res, prices[i] + rec(prices, i + 1, 0, dp));
    //     } else {
    //         res = Math.max(res, -prices[i] + rec(prices, i + 1, 1, dp));
    //     }

    //     dp[i][bought] = res;
    //     return res;
    // }
}