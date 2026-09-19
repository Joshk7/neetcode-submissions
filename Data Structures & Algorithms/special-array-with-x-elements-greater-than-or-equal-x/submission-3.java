class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int i = 0, prev = -1, totalRight = nums.length;

        while (i < nums.length) {
            if (nums[i] == totalRight || (prev < totalRight && totalRight < nums[i])) {
                return totalRight;
            }

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }

            prev = nums[i];
            i++;
            totalRight = nums.length - i;
        }

        return -1;
    }
}