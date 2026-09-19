class Solution {
    private int N;
    private final int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestBridge(int[][] grid) {
        N = grid.length;
        Queue<int[]> q = new LinkedList<>();

        boolean found = false;
        for (int r = 0; r < N; r++) {
            if (found) break;
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c, q);
                    found = true;
                    break;
                }
            }
        }

        int res = 0;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];

                for (int[] d : direct) {
                    int nr = r + d[0], nc = c + d[1];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if (grid[nr][nc] == 1) return res;

                    if (grid[nr][nc] == 0) {
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            res++;
        }
        return res;
    }

    private void dfs(int[][] grid, int r, int c, Queue<int[]> q) {
        if (r < 0 || c < 0 || r >= N || c >= N || grid[r][c] != 1) {
            return;
        }

        grid[r][c] = 2;
        q.offer(new int[]{r, c});
        for (int[] d : direct) {
            dfs(grid, r + d[0], c + d[1], q);
        }
    }
}