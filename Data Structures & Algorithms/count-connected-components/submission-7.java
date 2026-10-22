class Solution {
    private List<List<Integer>> graph;
    private boolean[] visited;

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
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, -1});
                visited[i] = true;
                while (!q.isEmpty()) {
                    int[] top = q.poll();
                    int node = top[0];
                    int parent = top[1];

                    for (int nei : graph.get(node)) {
                        if (nei == parent) continue;
                        if (visited[nei]) continue;
                        visited[nei] = true;
                        q.offer(new int[]{nei, node});
                    }
                }
            }
        }

        return count;
    }
}
