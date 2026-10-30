class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> ans = new ArrayList<>();
        if (0 <= rStart && rStart < rows && 0 <= cStart && cStart < cols) {
            ans.add(new int[]{rStart, cStart});
        }

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int steps = 0;
        int r = rStart, c = cStart;
        while (ans.size() < rows * cols) {
            if (direction == 0 || direction == 2) {
                steps++;
            }

            int[] dir = directions[direction];
            int dr = dir[0];
            int dc = dir[1];
            for (int step = 0; step < steps; step++) {
                r += dr;
                c += dc;
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    ans.add(new int[]{r, c});
                }
            }
            direction = (direction + 1) % 4;
        }

        int n = ans.size();
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}
