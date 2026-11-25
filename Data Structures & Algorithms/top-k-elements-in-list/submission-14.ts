class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums: number[], k: number): number[] {
        const count: { [key: number]: number } = {};
        const freq: number[][] = Array.from(
            { length: nums.length + 1 },
            () => [],
        );

        for (const n of nums) {
            count[n] = (count[n] || 0) + 1;
        }

        for (const n in count) {
            freq[count[n]].push(parseInt(n));
        }

        const res: number[] = [];
        for (let i = freq.length - 1; i > 0; i--) {
            for (const n of freq[i]) {
                res.push(n);
                if (res.length === k) {
                    return res;
                }
            }
        }
        return res;
    }
}
