class Solution {

    private int n; 
    private int[] nums;
    private int[] dp;

    public int rob(int[] nums) {
        n = nums.length;
        this.nums = nums;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take = nums[i] + dfs(i + 2);
        int skip = dfs(i + 1);
        int result = Math.max(take, skip);
        dp[i] = result;
        return dp[i];
    }
}
