class Solution {
    private List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(sb, 0, n);
        return ans;
    }

    private void backtrack(StringBuilder sb, int open, int n) {
        if (sb.length() == 2 * n) {
            if (open == 0) {
                ans.add(sb.toString());
            }
            return;
        }

        sb.append("(");
        backtrack(sb, open + 1, n);
        sb.deleteCharAt(sb.length() - 1);
        if (open == 0) {
            return;
        }
        sb.append(")");
        backtrack(sb, open - 1, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}
