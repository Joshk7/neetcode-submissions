class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] f : flights) {
            graph.get(f[0]).add(new int[]{f[1], f[2]}); // {to, price}
        }

        // PriorityQueue ordered by price: [price, node, stops]
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[]{0, src, 0});

        // Track the minimum stops to reach a node at a certain price, 
        // or simply a minStops array to prune worse paths.
        // minStops[node] = minimum stops recorded to reach this node
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int price = curr[0];
            int node = curr[1];
            int stops = curr[2];

            if (node == dst) return price;

            // If we've already reached this node with fewer or equal stops 
            // and a <= price, we can skip it.
            if (stops > k || stops >= minStops[node]) {
                // Note: sometimes a higher stop count is okay if price is lower, 
                // but tracking minStops helps prune redundant worse paths.
                continue;
            }
            minStops[node] = stops;

            for (int[] nei : graph.get(node)) {
                int nextNode = nei[0];
                int nextPrice = nei[1];
                q.offer(new int[]{price + nextPrice, nextNode, stops + 1});
            }
        }

        return -1;
    }
}