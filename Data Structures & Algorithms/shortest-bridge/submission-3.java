class Solution {
    public int shortestBridge(int[][] grid) {
        int N = grid.length;
        int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q2 = new LinkedList<>();

        boolean found = false;
        for (int r = 0; r < N; r++) {
            if (found) break;
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    Queue<int[]> q1 = new LinkedList<>();
                    q1.offer(new int[]{r, c});
                    grid[r][c] = 2;

                    while (!q1.isEmpty()) {
                        int[] cell = q1.poll();
                        int x = cell[0], y = cell[1];
                        q2.offer(new int[]{x, y});

                        for (int[] d : direct) {
                            int nx = x + d[0], ny = y + d[1];
                            if (nx >= 0 && ny >= 0 && nx < N && ny < N && grid[nx][ny] == 1) {
                                grid[nx][ny] = 2;
                                q1.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    found = true;
                    break;
                }
            }
        }

        int res = 0;
        while (!q2.isEmpty()) {
            for (int i = q2.size(); i > 0; i--) {
                int[] cell = q2.poll();
                int x = cell[0], y = cell[1];

                for (int[] d : direct) {
                    int nx = x + d[0], ny = y + d[1];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (grid[nx][ny] == 1) return res;
                        if (grid[nx][ny] == 0) {
                            grid[nx][ny] = 2;
                            q2.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            res++;
        }
        return res;
    }
}