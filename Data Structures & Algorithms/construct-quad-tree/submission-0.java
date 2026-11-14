class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length, grid.length);
    }

    private Node helper(int[][] grid, int r1, int c1, int r2, int c2) {
        // Base case: Check if all values in the current region are the same
        if (isUniform(grid, r1, c1, r2, c2)) {
            return new Node(grid[r1][c1] == 1, true);
        }

        // Otherwise, it's an internal node with 4 children
        Node root = new Node();
        int rowMid = r1 + (r2 - r1) / 2;
        int colMid = c1 + (c2 - c1) / 2;

        root.topLeft = helper(grid, r1, c1, rowMid, colMid);
        root.topRight = helper(grid, r1, colMid, rowMid, c2);
        root.bottomLeft = helper(grid, rowMid, c1, r2, colMid);
        root.bottomRight = helper(grid, rowMid, colMid, r2, c2);

        return root;
    }

    private boolean isUniform(int[][] grid, int r1, int c1, int r2, int c2) {
        int val = grid[r1][c1];
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}