class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % k != 0) return false;

        int target = total / k;
        int n = nums.length;
        int N = 1 << n;
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int mask = 0; mask < N; mask++) {
            if (dp[mask] == -1) continue;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0 && dp[mask] + nums[i] <= target) {
                    dp[mask | (1 << i)] = (dp[mask] + nums[i]) % target;
                }
            }
        }

        return dp[N - 1] == 0;
    }
}