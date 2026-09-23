class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return backtrack(0, nums, dp);
    }

    private int backtrack(int i, int[] nums, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int rob = nums[i] + backtrack(i + 2, nums, dp);
        int skip = backtrack(i + 1, nums, dp);
        int res = Math.max(rob, skip);
        dp[i] = res;
        return res;
    }
}
