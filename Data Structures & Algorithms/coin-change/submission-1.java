class Solution {
    private int[] coins;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        this.coins = coins;
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

        int take = Integer.MAX_VALUE;
        if (amount >= coins[index]) {
            int res = backtrack(index, amount - coins[index]);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }

        int skip = backtrack(index - 1, amount);
        return Math.min(take, skip);
    }
}
