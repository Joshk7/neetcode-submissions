class Solution {
    private int m;
    private int n;
    private int[][] grid;
    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int max = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, dfs(r, c));
                }
            }
        }

        return max;
    }

    private boolean valid(int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    private int dfs(int r, int c) {
        grid[r][c] = 0;
        int res = 1;
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (!valid(nr, nc)) continue;
            if (grid[nr][nc] == 0) continue;
            grid[nr][nc] = 0;
            res += dfs(nr, nc);

        }
        return res;
    }
}
