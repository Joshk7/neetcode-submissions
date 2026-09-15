class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;

        if (n <= 1) {
            return true;
        }

        int dec = 0;
        int inc = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) {
                dec++;
            }

            if (nums[i - 1] <= nums[i]) {
                inc++;
            }
        }

        return dec == n - 1 || inc == n - 1;
    }
}