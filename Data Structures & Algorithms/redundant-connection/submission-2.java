class Solution {
    private boolean[] seen;
    private List<List<Integer>> graph;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        graph = new ArrayList<>();
        for (int node = 0; node < n; node++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            seen = new boolean[n];
            if (cycle(edge[0], -1)) {
                return edge;
            }
        }

        return new int[2];
    }

    private boolean cycle(int node, int parent) {
        if (seen[node]) {
            return true;
        }

        seen[node] = true;
        for (int nei : graph.get(node)) {
            if (nei == parent) continue;
            if (cycle(nei, node)) {
                return true;
            }
        }
        return false;
    }
}
