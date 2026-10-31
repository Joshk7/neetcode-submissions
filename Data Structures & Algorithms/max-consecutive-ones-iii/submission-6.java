class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int l = 0;
        int r = 0;
        int n = nums.length;
        int longest = 0;
        while (r < n) {
            int num = nums[r];
            zeros += num == 0 ? 1 : 0;
            if (zeros > k) {
                zeros -= nums[l] == 0 ? 1 : 0;
                l++;
            }
            longest = Math.max(longest, r - l + 1);
            r++;
        }
        return longest;
    }
}