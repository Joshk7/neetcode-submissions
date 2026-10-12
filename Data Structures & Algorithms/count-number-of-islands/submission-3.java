class Solution {
    private boolean valid(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public int numIslands(char[][] grid) {
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] seen = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int islands = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (!seen[r][c] && grid[r][c] == '1') {
                    islands++;
                    queue.offer(new int[]{r, c});
                    seen[r][c] = true;
                    while (!queue.isEmpty()) {
                        int[] top = queue.poll();
                        int row = top[0];
                        int col = top[1];
                        for (int[] dir : directions) {
                            int nr = row + dir[0];
                            int nc = col + dir[1];
                            if (!valid(nr, nc, n, m)) continue;
                            if (seen[nr][nc]) continue;
                            if (grid[nr][nc] == '0') continue;
                            seen[nr][nc] = true;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        return islands;
    }
}
