class Solution {
    private boolean[] visited;
    private Map<Integer, List<Integer>> graph;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        graph = new HashMap<>();
        for (int[] prereq : prerequisites) {
            graph.computeIfAbsent(prereq[0], k -> new ArrayList());
            graph.get(prereq[0]).add(prereq[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            visited = new boolean[numCourses];
            if (hasCycle(course)) return false;
        }

        return true;
    }

    private boolean hasCycle(int node) {
        if (!graph.containsKey(node)) {
            return false;
        }

        if (visited[node]) {
            return true;
        }

        visited[node] = true;
        List<Integer> prereqs = graph.get(node);
        for (int prereq : prereqs) {
            if (hasCycle(prereq)) return true;
        }
        visited[node] = false;
        graph.put(node, new ArrayList<>());
        return false;
    }
}
