class Solution {
    private int m;
    private int n;
    private int[][] dp;

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        this.dp = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dp[r][c] = -1;
            }
        }

        return backtrack(0, 0);
    }

    private int backtrack(int r, int c) {
        if (r == (m - 1) && c == (n - 1)) return 1;
        if (r >= m || c >= n) return 0;
        if (dp[r][c] != -1) return dp[r][c];
        int down = backtrack(r + 1, c);
        int right = backtrack(r, c + 1);
        dp[r][c] = down + right;
        return dp[r][c];
    }
}
