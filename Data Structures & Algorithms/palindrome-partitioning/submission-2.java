class Solution {
    private List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, s);
        return ans;
    }

    private void backtrack(List<String> cur, int i, String s) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (palindrome(i, j, s)) {
                cur.add(s.substring(i, j + 1));
                backtrack(cur, j + 1, s);
                cur.remove(cur.size() - 1);
            }
        }

        return;
    }

    private boolean palindrome(int l, int r, String s) {
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
