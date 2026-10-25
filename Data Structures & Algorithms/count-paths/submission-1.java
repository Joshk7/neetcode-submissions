class Solution {
    private int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dp[r][c] = -1;
            }
        }

        return backtrack(m - 1, n - 1);
    }

    private int backtrack(int r, int c) {
        if (r == 0 || c == 0) return 1;
        if (dp[r][c] != -1) return dp[r][c];
        int up = backtrack(r - 1, c);
        int left = backtrack(r, c - 1);
        dp[r][c] = up + left;
        return dp[r][c];
    }
}
