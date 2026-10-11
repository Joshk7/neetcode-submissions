class Solution {
    private String[] mappings;
    private List<String> ans;

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.equals("")) {
            return ans;
        }

        mappings = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        StringBuilder sb = new StringBuilder();
        backtrack(sb, 0, digits);
        return ans;
    }

    private void backtrack(StringBuilder sb, int i, String digits) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        char c = digits.charAt(i);
        String neighbors = mappings[c - '0'];
        for (char nei : neighbors.toCharArray()) {
            sb.append(nei);
            backtrack(sb, i + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }

        return;
    }
}
