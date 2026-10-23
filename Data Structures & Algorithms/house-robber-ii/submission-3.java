class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, n - 1), helper(nums, 1, n));
    }

    private int helper(int[] nums, int l, int r) {
        int n = r - l;
        if (n == 1) {
            return nums[l];
        }

        int[] dp = new int[n];
        dp[0] = nums[l];
        dp[1] = Math.max(nums[l], nums[l + 1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i + l], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
