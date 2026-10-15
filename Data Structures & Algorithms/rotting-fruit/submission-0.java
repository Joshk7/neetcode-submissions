class Solution {
    private boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) fresh++;
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int minutes = 0;
        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];

                for (int[] dir : directions) {
                    int nr = dir[0] + r;
                    int nc = dir[1] + c;
                    if (!isValid(nr, nc, ROWS, COLS)) continue;
                    if (grid[nr][nc] == 0 || grid[nr][nc] == 2) continue;
                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[]{nr, nc});
                }
            }
            minutes++;
        }

        if (fresh != 0) {
            return -1;
        }

        return minutes;
    }
}
