class Solution {
    private int n;
    private int[] dp;
    private int[] nums;

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);    
        this.nums = nums;

        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, backtrack(i));
        }
        return max;
    }

    private int backtrack(int i) {
        if (dp[i] != -1) {
            return dp[i];
        }

        int res = 1;
        for (int j = i + 1; j < n; j++) {
            if (nums[i] < nums[j]) {
                res = Math.max(res, 1 + backtrack(j));
            }
        }

        dp[i] = res;
        return dp[i];
    }
}
