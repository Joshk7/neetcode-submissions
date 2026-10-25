class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    private void transpose(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        for (int r = 0; r < ROWS; r++) {
            for (int c = r + 1; c < COLS; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = tmp;
            }
        }
    }

    private void reverse(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS / 2; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[r][COLS - 1 - c];
                matrix[r][COLS - 1 - c] = tmp;
            }
        }
    }
}
