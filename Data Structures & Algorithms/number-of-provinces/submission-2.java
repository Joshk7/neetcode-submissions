class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;

        for (int i =0 ; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited, n);
                res++;
            }
        }

        return res;
    }

    private void dfs(int node, int[][] isConnected, boolean[] visited, int n) {
        visited[node] = true;
        for (int nei = 0; nei < n; nei++) {
            if (isConnected[node][nei] == 1 && !visited[nei]) {
                dfs(nei, isConnected, visited, n);
            }
        }
    }
}