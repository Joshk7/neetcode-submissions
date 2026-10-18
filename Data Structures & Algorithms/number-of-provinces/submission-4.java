class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                visited[i] = true;
                q.add(i);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int nei = 0; nei < n; nei++) {
                        if (isConnected[node][nei] == 1 && ! visited[nei]) {
                            visited[nei] = true;
                            q.add(nei);
                        }
                    }
                }
            }
        }

        return res;
    }
}