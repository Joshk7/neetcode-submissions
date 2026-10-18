class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int l, int r) {
        if (l == r) return l;
        int m = l + (r - l) / 2;
        if (nums[m] > nums[m + 1]) {
            return binarySearch(nums, l, m);
        }
        return binarySearch(nums, m + 1, r);
    }
}