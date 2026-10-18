class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int res =0 ;

        for (int i = 0; i < n; i++) {
            if (isConnected[i][i] == 1) {
                dfs(i, isConnected, n);
                res++;
            }
        }

        return res;
    }

    private void dfs(int node, int[][] isConnected, int n) {
        isConnected[node][node] = 0;
        for (int nei = 0; nei < n; nei++) {
            if (node != nei && isConnected[node][nei] == 1 && isConnected[nei][nei] == 1) {
                dfs(nei, isConnected, n);
            }
        }
    }
}