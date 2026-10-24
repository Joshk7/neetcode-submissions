class Solution {
    private int[][] dp;
    private int[] prices;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        this.prices = prices;
        return backtrack(0, 0);
    }

    private int backtrack(int day, int bought) {
        if (day >= prices.length) {
            return 0;
        }

        if (dp[day][bought] != -1) {
            return dp[day][bought];
        }

        int res = backtrack(day + 1, bought);
        if (bought == 1) {
            res = Math.max(res, prices[day] + backtrack(day + 1, 0));
        } else {
            res = Math.max(res, -prices[day] + backtrack(day + 1, 1));
        }
        dp[day][bought] = res;
        return res;
    }
}