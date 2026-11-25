class Solution {
    /**
     * @param {number[]} nums
     * @return {number[]}
     */
    productExceptSelf(nums: number[]): number[] {
        const n = nums.length;
        const prefix: number[] = new Array(n + 1).fill(0);
        prefix[0] = 1;
        const suffix: number[] = new Array(n + 1).fill(0);
        suffix[n] = 1;
        for (let i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] * nums[i];
        }

        for (let i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        const answer: number[] = new Array(n).fill(0);
        for (let i = 0; i < n; i++) {
            answer[i] = prefix[i] * suffix[i + 1];
        }

        console.log(suffix);
        console.log(prefix);
        return answer;
    }
}
