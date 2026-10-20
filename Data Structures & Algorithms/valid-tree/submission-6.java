class Solution {
    private Set<Integer> visited;
    private Map<Integer, List<Integer>> graph;

    public boolean validTree(int n, int[][] edges) {
        visited = new HashSet<>();
        graph = new HashMap<>();

        for (int node = 0; node < n; node++) {
            graph.put(node, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        if (!dfs(0, -1)) return false;

        return visited.size() == n;
    }

    private boolean dfs(int node, int parent) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        for (int nei : graph.get(node)) {
            if (nei == parent) continue;
            if (visited.contains(nei)) return false;
            dfs(nei, node);
        }

        return true;
    }
}
