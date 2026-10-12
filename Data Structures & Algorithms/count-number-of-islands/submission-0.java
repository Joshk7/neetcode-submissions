class Solution {
    private int n;
    private int m;
    private char[][] grid;
    private boolean[][] seen;
    private int[][] directions = new int[][]{
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    public int numIslands(char[][] grid) {
        int islands = 0;
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
        seen = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (!seen[r][c] && grid[r][c] == '1') {
                    islands++;
                    dfs(r, c);
                }
            }
        }
        return islands;
    }

    private boolean valid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    private void dfs(int r, int c) {
        if (seen[r][c]) {
            return;
        }

        seen[r][c] = true;
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (!valid(nr, nc)) continue;
            if (grid[nr][nc] == '0') continue;

            dfs(nr, nc);
        }
        return;
    }
}
