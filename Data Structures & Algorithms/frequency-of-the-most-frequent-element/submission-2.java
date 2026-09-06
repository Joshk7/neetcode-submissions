class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int total = 0;
        int ans = 0;
        while (right < nums.length) {
            total += nums[right];

            while (nums[right] * (right - left + 1) > total + k) {
                total -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}