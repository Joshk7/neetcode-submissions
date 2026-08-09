class Solution {

    HashMap<Integer, ArrayList<Integer>> graph;
    HashSet<Integer> visit;

    boolean dfs(int node, int parent) {
        if (visit.contains(node)) {
            return false;
        }

        if (graph.get(node) == null) {
            return true;
        }

        visit.add(node);
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }

            if (!dfs(child, node)) {
                return false;
            }
        }

        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) {
            return true;
        }

        this.graph = new HashMap<Integer, ArrayList<Integer>>();
        this.visit = new HashSet<Integer>();

        for (int[] edge : edges) {
            if (edge[0] == edge[1]) {
                return false;
            }

            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<Integer>());
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<Integer>());
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return dfs(0, -1) && n == visit.size();
    }
}
