class Solution {
    private char[][] matrix;
    private int ROWS;
    private int COLS;
    private int[][] dp;

    public int maximalSquare(char[][] matrix) {
        this.matrix = matrix;
        ROWS = matrix.length;
        COLS = matrix[0].length;
        dp = new int[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            Arrays.fill(dp[r], -1);
        }
        recurse(0, 0);
        int ans = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                System.out.print("%d,".formatted(dp[r][c]));
                ans = Math.max(ans, dp[r][c] * dp[r][c]);
            }
            System.out.println("");
        }
        return ans;
    }

    private int recurse(int r, int c) {
        if (r >= ROWS || c >= COLS) {
            return 0;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int right = recurse(r, c + 1);
        int bottom = recurse(r + 1, c);
        int diagonal = recurse(r + 1, c + 1);
        dp[r][c] = 0;
        if (matrix[r][c] == '1') {
            int result = 1 + Math.min(Math.min(right, bottom), diagonal);
            dp[r][c] = result;
        }
        return dp[r][c];
    }
}