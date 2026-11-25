class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums: number[], k: number): number[] {
        const count: { [key: number]: number } = {};
        for (const num of nums) {
            count[num] = (count[num] || 0) + 1;
        }

        const heap = new MinPriorityQueue((x: [number, number]) => x[1]);
        for (const [num, cnt] of Object.entries(count)) {
            heap.enqueue([Number(num), cnt]);
            if (heap.size() > k) heap.dequeue();
        }

        const res: number[] = [];
        for (let i = 0; i < k; i++) {
            const [num, cnt]: [number, number] = heap.dequeue();
            res.push(num);
        }

        return res;
    }
}
