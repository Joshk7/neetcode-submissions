class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.put(x[i], Math.max(m.getOrDefault(x[i], 0), y[i]));
        }

        if (m.size() < 3) {
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int val : m.values()) {
            minHeap.offer(val);
            if (minHeap.size() > 3) {
                minHeap.poll();
            }
        }

        int ans = 0;
        while (!minHeap.isEmpty()) {
            ans += minHeap.poll();
        }
        return ans;
    }
}