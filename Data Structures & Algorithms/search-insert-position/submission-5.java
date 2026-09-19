class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -index - 1;
        
        // int l = 0;
        // int r = nums.length;

        // while (l < r) {
        //     int m = l + (r - l) / 2;
        //     if (nums[m] < target) {
        //         l = m + 1;
        //     } else {
        //         r = m;
        //     }
        // }

        // return l;
    }
}