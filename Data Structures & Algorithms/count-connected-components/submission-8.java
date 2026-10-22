class Solution {
    private List<List<Integer>> graph;
    private boolean[] visited;

    private void dfs(int node, int parent) {
        visited[node] = true;

        for (int nei : graph.get(node)) {
            if (nei == parent) continue;
            if (visited[nei]) continue;
            dfs(nei, node);
        }
    }

    public int countComponents(int n, int[][] edges) {
        graph = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, -1);
            }
        }

        return count;
    }
}
