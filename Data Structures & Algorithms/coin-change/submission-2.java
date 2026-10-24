class Solution {
    private int[] coins;
    private int[][] memo;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        this.coins = coins;
        this.memo = new int[n + 1][amount + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                this.memo[i][j] = -1;
            }
        }
        int ans = backtrack(n - 1, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int backtrack(int index, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (index < 0 || amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (this.memo[index][amount] != -1) {
            return this.memo[index][amount];
        }

        int take = Integer.MAX_VALUE;
        if (amount >= coins[index]) {
            int res = backtrack(index, amount - coins[index]);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }

        int skip = backtrack(index - 1, amount);
        int res = Math.min(take, skip);
        this.memo[index][amount] = res;
        return res;
    }
}
