class TrieNode {
    TrieNode[] children;
    boolean ending;

    public TrieNode() {
        children = new TrieNode[26];
        ending = false;
    }
}

class Solution {

    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private char[][] board;
    private boolean[][] visited;
    private Set<String> ans;
    private TrieNode root;
    
    private void backtrack(int r, int c, TrieNode node, StringBuilder sb) {
        char letter = board[r][c];

        if (node.children[letter - 'a'] == null) {
            return;
        }

        visited[r][c] = true;
        node = node.children[letter - 'a'];
        sb.append(letter);

        if (node.ending) {
            ans.add(sb.toString());
        }

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (isValid(nr, nc)) {
                backtrack(nr, nc, node, sb);
            }
        }

        visited[r][c] = false;
        sb.deleteCharAt(sb.length() - 1);

        return;
    }

    private boolean isValid(int r, int c) {
        return 0 <= r && r < board.length && 0 <= c && c < board[0].length && !visited[r][c];
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.ending = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int ROWS = board.length;
        int COLS = board[0].length;
        this.board = board;
        ans = new HashSet<>();

        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                visited = new boolean[ROWS][COLS];
                backtrack(r, c, root, new StringBuilder());
            }
        }

        return new ArrayList<>(ans);
    }
}
