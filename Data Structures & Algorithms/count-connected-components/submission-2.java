class Solution {
    HashMap<Integer, ArrayList<Integer>> graph;
    HashSet<Integer> visit = new HashSet<Integer>();

    void dfs(int node, int parent) {
        if (visit.contains(node)) {
            return;
        }

        if (graph.get(node) == null) {
            return;
        }

        visit.add(node);
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }

            dfs(child, node);
        }

        return;
    }

    public int countComponents(int n, int[][] edges) {
        this.graph = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visit.contains(i)) {
                count++;
                dfs(i, -1);
            }
        }

        return count;
    }
}
