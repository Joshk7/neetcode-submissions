class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int xVal = x[i];
            int yVal = y[i];
            if (!m.containsKey(xVal)) {
                m.put(xVal, yVal);
            }
            
            if (m.get(xVal) < yVal) {
                m.put(xVal, yVal);
            }
        }

        if (m.size() < 3) {
            return -1;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int val = e.getValue();
            int key = e.getKey();
            minHeap.offer(new int[]{val, key});
            if (minHeap.size() > 3) {
                minHeap.poll();
            }
        }

        int ans = 0;
        while (!minHeap.isEmpty()) {
            ans += minHeap.poll()[0];
        }
        return ans;
    }
}