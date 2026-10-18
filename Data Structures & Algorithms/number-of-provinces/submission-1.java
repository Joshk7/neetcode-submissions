class Solution {
    private int[][] isConnected;
    private int cities;
    public int findCircleNum(int[][] isConnected) {
        cities = isConnected.length;
        this.isConnected = isConnected;
        int ans = 0;
        for (int city = 0; city < cities; city++) {
            if (dfs(city)) ans++;
        }
        return ans;
    }

    private boolean dfs(int city) {
        boolean newProvince = false;
        for (int nei = 0; nei < cities; nei++) {
            if (isConnected[city][nei] == 0) continue;
            newProvince = true;
            isConnected[city][nei] = 0;
            dfs(nei);
        }
        return newProvince;
    }

}