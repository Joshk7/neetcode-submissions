class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    findMin(nums: number[]): number {
        let l: number = 0,
            r: number = nums.length - 1;
        
        while (l < r) {
            let m: number = l + Math.floor((r - l) / 2);
            if (nums[m] <= nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return nums[l];
    }
}
