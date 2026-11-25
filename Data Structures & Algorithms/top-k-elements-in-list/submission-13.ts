class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums: number[], k: number): number[] {
        const counts = new Map<number, number>();
        let maxF = 0;

        for (let num of nums) {
            counts.set(num, (counts.get(num) ?? 0) + 1);
            maxF = Math.max(maxF, counts.get(num));
        }

        console.log(counts);

        const freqs: number[][] = Array.from({ length: maxF + 1}, () => []);
        for (let [k, v] of counts) {
            freqs[v].push(k);
        }

        const answer: number[] = [];
        for (let freq = maxF; freq > 0 && answer.length < k; freq--) {
            for (const num of freqs[freq]) {
                answer.push(num);
                if (answer.length === k) break;
            }
        }

        return answer;
    }
}
