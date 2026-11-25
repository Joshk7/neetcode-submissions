class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    longestConsecutive(nums: number[]): number {
        let longest = 0;
        const unique = new Set<number>(nums);
        for (let num of unique) {
            if (!unique.has(num - 1)) {
                let start = num;
                while (unique.has(num + 1)) {
                    num++;
                }
                longest = Math.max(longest, num - start + 1);
            }
        }
        return longest;
    }
}
