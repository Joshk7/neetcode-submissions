class Solution {
    /**
     * @param {number[]} nums
     * @return {number[]}
     */
    productExceptSelf(nums: number[]): number[] {
        const n = nums.length;
        const prefix: number[] = new Array(n + 1).fill(0);
        prefix[0] = 1;
        for (let i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] * nums[i];
        }
        
        let suffix = 1;
        const answer: number[] = new Array(n).fill(0);
        for (let i = n - 1; i >= 0; i--) {
            answer[i] = prefix[i] * suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}
