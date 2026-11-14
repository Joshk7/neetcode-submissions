class Solution {
    private int m;
    private int n;
    private int maxMove;
    private int[][][] cache;
    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        this.maxMove = maxMove;
        this.cache = new int[m][n][maxMove + 1];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                for (int move = 0; move <= maxMove; move++) {
                    this.cache[r][c][move] = -1;
                }
            }
        }
        return backtrack(startRow, startColumn, 0);
    }

    private int backtrack(int r, int c, int move) {
        if (move > maxMove) {
            return 0;
        }

        if (!isValid(r, c)) {
            return 1;
        }

        if (cache[r][c][move] != -1) {
            return cache[r][c][move];
        }

        int result = 0;
        for (int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];
            result += backtrack(nr, nc, move + 1);
            result %= MOD;
        }

        cache[r][c][move] = result;
        return result;
    }

    private boolean isValid(int r, int c) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }
}
