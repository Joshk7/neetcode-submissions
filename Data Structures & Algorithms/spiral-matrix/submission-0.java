public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int top = 0;
        int left = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;

        while (top < bottom && left < right) {
            // right
            for (int c = left; c < right; c++) {
                res.add(matrix[top][c]);
            }
            top++;

            // down
            for (int r = top; r < bottom; r++) {
                res.add(matrix[r][right - 1]);
            }
            right--;

            if (!(left < right && top < bottom)) break;

            // left
            for (int c = right - 1; c >= left; c--) {
                res.add(matrix[bottom - 1][c]);
            }
            bottom--;

            // up
            for (int r = bottom - 1; r >= top; r--) {
                res.add(matrix[r][left]);
            }
            left++;
        }

        return res;
    }
}