class Solution {
    private int n;
    private int amount;
    private int[] coins;
    private int[][] dp;

    public int change(int amount, int[] coins) {
        this.n = coins.length;
        this.amount = amount;
        this.coins = coins;
        this.dp = new int[n + 1][amount + 1];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < amount + 1; c++) {
                this.dp[r][c] = -1;
            }
        }
        return backtrack(0, 0);
    }

    private int backtrack(int i, int total) {
        if (total > amount) {
            return 0;
        }

        if (i == n) {
            return total == amount ? 1 : 0;
        }

        if (dp[i][total] != -1) return dp[i][total];

        int res = 0;
        res += backtrack(i, total + coins[i]);
        res += backtrack(i + 1, total);

        dp[i][total] = res;
        return dp[i][total];
    }
}
