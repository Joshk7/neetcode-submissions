class Solution {
    public int maximalSquare(char[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int[][] dp = new int[ROWS + 1][COLS + 1];
        int ans = 0;

        for (int r = ROWS - 1; r >= 0; r--) {
            for (int c = COLS - 1; c >= 0; c--) {
                if (matrix[r][c] == '0') continue;
                int right = dp[r][c + 1];
                int down = dp[r + 1][c];
                int diagonal = dp[r + 1][c + 1];
                dp[r][c] = 1 + Math.min(Math.min(right, down), diagonal);
                ans = Math.max(ans, (int) Math.pow(dp[r][c], 2));
            }
        }

        // for (int r = 0; r <= ROWS; r++) {
        //     for (int c = 0; c <= COLS; c++) {
        //         System.out.print("%d,".formatted(dp[r][c]));
        //     }
        //     System.out.println("");
        // }

        return ans;
    }
}