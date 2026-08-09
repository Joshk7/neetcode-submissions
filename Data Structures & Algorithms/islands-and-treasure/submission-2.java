class Solution {
    HashSet<String> visited = new HashSet<String>();
    ArrayDeque<String> queue = new ArrayDeque<String>();
    int rows;
    int cols;
    int[][] grid;

    private void addRoom(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= rows || nc >= cols ||
            grid[nr][nc] == -1 || visited.contains(nr + "," + nc)) {
            return;
        }
        visited.add(nr + "," + nc);
        queue.offerLast(nr + "," + nc);
    }

    public void islandsAndTreasure(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.offerLast(r + "," + c);
                    visited.add(r + "," + c);
                }
            }
        }

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String[] split = queue.pollFirst().split(",");
                int r = Integer.parseInt(split[0]);
                int c = Integer.parseInt(split[1]);
                grid[r][c] = dist;
                addRoom(r + 1, c);
                addRoom(r - 1, c);
                addRoom(r, c + 1);
                addRoom(r, c - 1);
            }
            dist++;
        }
    }
}
