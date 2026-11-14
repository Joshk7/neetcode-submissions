class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int MOD = 1000000007;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;

        int count = 0;

        for (int i = 0; i < maxMove; i++) {
            int[][] newDp = new int[m][n];

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] == 0) continue;

                    for (int[] dir : dirs) {
                        int nr = r + dir[0], nc = c + dir[1];

                        if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                            count = (count + dp[r][c]) % MOD;
                        } else {
                            newDp[nr][nc] = (newDp[nr][nc] + dp[r][c]) % MOD;
                        }
                    }
                }
            }

            dp = newDp;
        }

        return count;
    }
}
