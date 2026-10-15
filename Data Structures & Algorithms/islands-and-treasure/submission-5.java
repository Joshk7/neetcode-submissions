class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] top = q.poll();
            int cr = top[0];
            int cc = top[1];
            for (int[] dir : directions) {
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                if (!valid(nr, nc, m, n)) continue;
                if (grid[nr][nc] != Integer.MAX_VALUE) continue;
                grid[nr][nc] = Math.min(grid[nr][nc], grid[cr][cc] + 1);
                q.offer(new int[]{nr, nc});
            }
        }
    }

    private boolean valid(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
