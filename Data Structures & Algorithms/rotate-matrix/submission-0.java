class Solution {
    public void rotate(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        for (int r = 0; r < (ROWS + 1) / 2; r++) {
            for (int c = 0; c < COLS / 2; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[COLS - 1 - c][r];
                matrix[COLS - 1 - c][r] = matrix[ROWS - 1 - r][COLS - 1 - c];
                matrix[ROWS - 1 - r][COLS - 1 - c] = matrix[c][ROWS - 1 - r];
                matrix[c][ROWS - 1 - r] = tmp;
            }
        }
    }
}
