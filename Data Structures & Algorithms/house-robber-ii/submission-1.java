class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, n - 1), helper(nums, 1, n));
    }

    private int helper(int[] nums, int l, int r) {
        int one = 0;
        int two = 0;
        for (int i = l; i < r; i++) {
            int tmp = Math.max(one + nums[i], two);
            one = two;
            two = tmp;
        }
        return two;
    }
}
