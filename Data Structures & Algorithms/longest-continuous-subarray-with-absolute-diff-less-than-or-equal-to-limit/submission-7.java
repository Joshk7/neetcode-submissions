class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int n = nums.length;
        int l = 0;
        int longest = 0;
        for (int r = 0; r < n; r++) {
            minHeap.offer(new int[]{nums[r], r});
            maxHeap.offer(new int[]{nums[r], r});
            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                l++;
                while (!maxHeap.isEmpty() && maxHeap.peek()[1] < l) {
                    maxHeap.poll();
                }

                while (!minHeap.isEmpty() && minHeap.peek()[1] < l) {
                    minHeap.poll();
                }
            }
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}