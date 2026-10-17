class Solution {

    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] p = new boolean[ROWS][COLS];
        boolean[][] a = new boolean[ROWS][COLS];

        Queue<int[]> pQ = new LinkedList<>();
        Queue<int[]> aQ = new LinkedList<>();

        for (int c = 0; c < COLS; c++) {
            pQ.add(new int[]{0, c});
            aQ.add(new int[]{ROWS - 1, c});
        }

        for (int r = 0; r < ROWS; r++) {
            pQ.add(new int[]{r, 0});
            aQ.add(new int[]{r, COLS - 1});
        }

        bfs(pQ, p, heights);
        bfs(aQ, a, heights);

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (p[r][c] && a[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0], c = node[1];
            ocean[r][c] = true;
            for (int [] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (
                    nr >= 0 && nr < heights.length && nc >= 0 &&
                    nc < heights[0].length && !ocean[nr][nc] &&
                    heights[nr][nc] >= heights[r][c]
                ) {
                    q.add(new int[]{nr, nc});    
                }
            }
        }
    }
}
