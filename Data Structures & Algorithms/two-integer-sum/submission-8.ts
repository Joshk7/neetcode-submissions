class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums: number[], target: number): number[] {
        const sums: Map<number, number> = new Map<number, number>();
        for (const [i, v] of nums.entries()) {
            if (sums.has(target - v)) {
                return [sums.get(target - v), i];
            }
            sums.set(v, i);
        }
    }
}
