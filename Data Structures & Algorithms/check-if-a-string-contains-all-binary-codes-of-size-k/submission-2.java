class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        Set<String> codes = new HashSet<>();
        backtrack(k, "", codes);
        for (int l = 0; l < n - k + 1; l++) {
            int r = l + k;
            String substring = s.substring(l, r);
            if (codes.contains(substring)) {
                codes.remove(substring);
            }
        }
        return codes.isEmpty();
    }

    private void backtrack(int k, String s, Set<String> codes) {
        if (k == 0) {
            codes.add(s);
            return;
        }

        backtrack(k - 1, s + "1", codes);
        backtrack(k - 1, s + "0", codes);
        return;
    }
}
