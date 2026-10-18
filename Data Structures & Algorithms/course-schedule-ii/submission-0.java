class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int course = 0; course < numCourses; course++) {
            graph.put(course, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            graph.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) q.offer(course);
        }

        int taken = 0;
        List<Integer> courses = new ArrayList<>();
        while (!q.isEmpty()) {
            int course = q.poll();
            courses.add(course);
            taken++;

            for (int nei : graph.get(course)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        if (taken < numCourses) return new int[]{};
        Collections.reverse(courses);

        int[] ans = new int[courses.size()];
        int index = 0;
        for (int course : courses) {
            ans[index++] = course;
        }
        return ans;
    }
}
