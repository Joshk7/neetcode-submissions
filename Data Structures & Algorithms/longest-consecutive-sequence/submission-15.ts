class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    longestConsecutive(nums: number[]): number {
        nums.sort((a, b) => a - b);
        let longest = 0;
        let n = nums.length;
        let i = 0;
        while (i < n) {
            let j = i;
            while (j + 1 < n && nums[j + 1] - nums[j] <= 1) {
                j++;
            }
            longest = Math.max(longest, nums[j] - nums[i] + 1);
            i = j + 1;
        }
        return longest;
    }
}
