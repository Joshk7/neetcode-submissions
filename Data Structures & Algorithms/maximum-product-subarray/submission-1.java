class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int curMin = 1;
        int curMax = 1;

        for (int num : nums) {
            int tmp = curMax * num;
            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            curMin = Math.min(Math.min(tmp, num * curMin), num);
            ans = Math.max(ans, curMax);
        }

        return ans;
    }
}
