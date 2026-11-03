class Solution {
    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int ROWS;
    private int COLS;
    private int[][] matrix;
    private int[][] memo;

    private boolean isValid(int r, int c) {
        return 0 <= r && r < ROWS && 0 <= c && c < COLS;
    }

    private int backtrack(int r, int c, int prev) {
        if (!isValid(r, c) || matrix[r][c] <= prev) {
            return 0;
        }

        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        int result = 1;
        for (int[] direction : directions) {
            int nr = direction[0] + r;
            int nc = direction[1] + c;
            result = Math.max(result, 1 + backtrack(nr, nc, matrix[r][c]));
        }

        memo[r][c] = result;
        return memo[r][c];
    }

    public int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        memo = new int[ROWS][COLS];
        this.matrix = matrix;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                memo[r][c] = -1;
            }
        }

        int longest = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int current = backtrack(r, c, Integer.MIN_VALUE);
                longest = Math.max(longest, current);
            }
        }

        return longest;
    }
}
