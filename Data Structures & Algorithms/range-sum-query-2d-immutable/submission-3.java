class NumMatrix {

    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefix = new int[m + 1][n + 1];

        for (int r = 0; r < m; r++) {
            int sum = 0;
            for (int c = 0; c < n; c++) {
                sum += matrix[r][c];
                int above = prefix[r][c + 1];
                prefix[r + 1][c + 1] = sum + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        int bottomRight = prefix[row2][col2];
        int above = prefix[row1 - 1][col2];
        int left = prefix[row2][col1 - 1];
        int topLeft = prefix[row1 - 1][col1 - 1];
        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */