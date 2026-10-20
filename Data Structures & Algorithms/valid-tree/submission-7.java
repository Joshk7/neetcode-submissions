class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int node = 0; node < n; node++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, -1});
        visited.add(0);

        while (!q.isEmpty()) {
            int[] top = q.poll();
            int node = top[0];
            int parent = top[1];

            for (int nei : graph.get(node)) {
                if (nei == parent) continue;
                if (visited.contains(nei)) return false;
                visited.add(nei);
                q.offer(new int[]{nei, node});
            }
        }

        return visited.size() == n;
    }
}
