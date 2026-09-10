class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                return a[0] - b[0];
            }
        );

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int distance = (x * x) + (y * y);
            minHeap.offer(new int[]{distance, x, y});
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = minHeap.poll();
            ans[i] = new int[]{point[1], point[2]};
        }

        return ans;
    }
}
