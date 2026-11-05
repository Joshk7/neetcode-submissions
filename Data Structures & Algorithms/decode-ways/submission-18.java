class Solution {
    public int numDecodings(String s) {
        Set<String> codes = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            codes.add(String.valueOf(i));
        }
        int[] cache = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cache[i] = -1;
        }
        return dfs(0, s, codes, cache);
    }

    private int dfs(int i, String s, Set<String> codes, int[] cache) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (cache[i] != -1) return cache[i];

        int result = dfs(i + 1, s, codes, cache);
        if (i + 1 < s.length() && codes.contains(s.substring(i, i + 2))) {
            result += dfs(i + 2, s, codes, cache);
        }

        cache[i] = result;
        return cache[i];
    }
}
