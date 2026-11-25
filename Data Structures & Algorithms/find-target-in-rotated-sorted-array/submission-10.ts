class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number}
     */
    search(nums: number[], target: number): number {
        let l = 0,
            r = nums.length - 1;
        
        while (l < r) {
            let m = l + Math.floor((r - l) / 2);
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        const pivot = l;
        const left = this.binarySearch(nums, 0, pivot, target);
        if (left !== -1) return left;
        return this.binarySearch(nums, pivot, nums.length - 1, target);
    }

    binarySearch(nums: number[], l: number, r: number, target: number) {
        while (l <= r) {
            let m = l + Math.floor((r - l) / 2);
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
