class Solution {
    
    private int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(dfs(0, cost), dfs(1, cost));
    }

    private int dfs(int i, int[] cost) {
        if (i >= cost.length) {
            return 0;
        }
        
        if (dp[i] != -1) {
            return dp[i];
        }

        int one = dfs(i + 1, cost);
        int two = dfs(i + 2, cost);
        dp[i] = cost[i] + Math.min(one, two);
        return dp[i];
    }
}
