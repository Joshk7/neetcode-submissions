class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int res = 1;

        for (int i = 0; i < n; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (max - min > limit) {
                    break;
                }
                res = Math.max(res, j - i + 1);
            }
        }

        return res;
    }
}