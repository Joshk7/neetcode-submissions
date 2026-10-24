class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int num : nums) {
            if (cur < 0) {
                cur = 0;
            }
            cur += num;
            max = Math.max(max, cur);
        }
        return max;
    }
}
