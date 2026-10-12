class Solution {
    private boolean valid(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public void solve(char[][] board) {
        int[][] directions = new int[][]{
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            if (board[r][0] == 'O') {
                seen[r][0] = true;
                queue.offer(new int[]{r, 0});
            }

            if (board[r][n - 1] == 'O') {
                seen[r][n - 1] = true;
                queue.offer(new int[]{r, n - 1});
            }
        }

        for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') {
                seen[0][c] = true;
                queue.offer(new int[]{0, c});
            }

            if (board[m - 1][c] == 'O') {
                seen[m - 1][c] = true;
                queue.offer(new int[]{m - 1, c});
            }
        }

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int row = top[0];
            int col = top[1];
            seen[row][col] = true;
            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (!valid(nr, nc, m, n)) continue;
                if (board[nr][nc] == 'X') continue;
                if (seen[nr][nc]) continue;
                seen[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (seen[r][c]) {
                    board[r][c] = 'O';
                } else {
                    board[r][c] = 'X';
                }
            }
        }
    }
}
