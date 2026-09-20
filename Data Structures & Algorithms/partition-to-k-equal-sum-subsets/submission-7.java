class Solution {
    private int target;
    private int n;
    private Boolean[] dp;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % k != 0) return false;

        this.target = total / k;
        this.n = nums.length;
        Arrays.sort(nums);
        reverse(nums);
        dp = new Boolean[1 << this.n];

        return backtrack(nums, 0, k, 0, (1 << this.n) - 1);
    }

    private boolean backtrack(
        int[] nums,
        int i,
        int k,
        int sum,
        int mask
    ) {
        if (dp[mask] != null) return dp[mask];
        if (k == 0) {
            dp[mask] = true;
            return dp[mask];
        }
        if (sum == target) {
            dp[mask] = backtrack(nums, 0, k - 1, 0, mask);
            return dp[mask];
        }
        for (int j = i; j < n; j++) {
            if ((mask & (1 << j)) == 0 || sum + nums[j] > target) continue;
            if (backtrack(nums, j + 1, k, sum + nums[j], mask ^ (1 << j))) {
                return true;
            }
            if (sum == 0) return false;
        }
        dp[mask] = false;
        return false;
    }

    private void reverse(int[] nums) {
        for (int i = 0; i < n / 2; i++) {
            int tmp = nums[0];
            nums[0] = nums[n - i - 1];
            nums[n - i - 1] = tmp;
        }
    }
}