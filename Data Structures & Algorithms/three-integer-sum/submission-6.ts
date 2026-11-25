class Solution {
    /**
     * @param {number[]} nums
     * @return {number[][]}
     */
    threeSum(nums: number[]): number[][] {
        nums.sort((a, b) => a - b);
        const answer: number[][] = [];

        const n = nums.length;
        for (let i = 0; i < n; i++) {
            if (i !== 0 && nums[i - 1] === nums[i]) {
                continue;
            }

            let j = i + 1
            let k = n - 1;
            while (j < k) {
                const total = nums[i] + nums[j] + nums[k];
                if (total < 0) {
                    j++;
                } else if (total > 0) {
                    k--;
                } else {
                    answer.push([nums[i], nums[j], nums[k]]);
                    while (j + 1 < k && nums[j] === nums[j + 1]) {
                        j++;
                    }
                    j++;
                }
            }
        }

        return answer;
    }
}
