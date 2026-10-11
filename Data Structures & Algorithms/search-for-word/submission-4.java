class Solution {

    private int m;
    private int n;
    private char[][] board;
    private String word;
    private Set<String> visited;

    private int[][] directions = new int[][]{
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    private boolean valid(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    private boolean match(int r, int c, int index) {
        if (index == word.length() - 1 && word.charAt(index) == board[r][c]) {
            System.out.println("Row: %d, Col: %d, Index: %d".formatted(r, c, index));
            return true;
        }

        if (word.charAt(index) != board[r][c]) {
            return false;
        }

        visited.add(r + "," + c);

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (!valid(nr, nc, m, n) || visited.contains(nr + "," + nc)) continue;
            if (match(nr, nc, index + 1)) return true;
        }

        visited.remove(r + "," + c);

        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;
        visited = new HashSet<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                visited.clear();
                if (match(r, c, 0)) return true;
            }
        }
        return false;
    }
}
