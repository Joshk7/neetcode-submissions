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
                    max = Math.max(max, bfs(r, c));
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

    private int bfs(int r, int c) {
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c] = 0;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int tr = t[0];
            int tc = t[1];
            grid[r][c] = 0;
            
            for (int[] dir : directions) {
                int nr = tr + dir[0];
                int nc = tc + dir[1];
                if (!valid(nr, nc)) continue;
                if (grid[nr][nc] == 0) continue;
                grid[nr][nc] = 0;
                q.offer(new int[]{nr, nc});
            }
            ans++;
        }

        return ans;
    }
}
