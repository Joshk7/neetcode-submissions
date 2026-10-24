class Solution {
    private int sum;
    private int[] nums;
    private Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        this.sum = sum;
        this.nums = nums;
        this.dp = new Boolean[n][(sum + 1) / 2];
        return backtrack(0, 0);
    }

    private boolean backtrack(int i, int current) {
        if (i >= nums.length) return false;
        if (current * 2 > sum) return false;
        if (current * 2 == sum) return true;
        if (dp[i][current] != null) {
            return dp[i][current];
        }

        boolean take = backtrack(i + 1, current + nums[i]);
        boolean skip = backtrack(i + 1, current);
        boolean res = take || skip;
        dp[i][current] = res;
        return dp[i][current];
    }
}
