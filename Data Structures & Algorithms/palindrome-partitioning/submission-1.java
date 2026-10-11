class Solution {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> part = new ArrayList<>();
        dfs(0, 0, s, part);
        return res;
    }

    private void dfs(int j, int i, String s, List<String> part) {
        if (i >= s.length()) {
            if (i == j) {
                res.add(new ArrayList<>(part));
            }
            return;
        }

        if (isPali(s, j, i)) {
            part.add(s.substring(j, i + 1));
            dfs(i + 1, i + 1, s, part);
            part.remove(part.size() - 1);
        }

        dfs(j, i + 1, s, part);
    }

    private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
