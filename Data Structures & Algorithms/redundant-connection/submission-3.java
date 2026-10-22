class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int node = 0; node < n; node++) {
            if (indegree[node] == 1) {
                q.offer(node);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            indegree[node]--;

            for (int nei : graph.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 1) {
                    q.offer(nei);
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            if (indegree[u] == 2 && indegree[v] > 0) {
                return edge;
            }
        }

        return new int[0];
    }
}
