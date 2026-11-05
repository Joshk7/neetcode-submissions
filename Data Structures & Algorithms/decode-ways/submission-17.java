class Solution {
    private int[] cache;
    private Set<String> codes;

    private int backtrack(int i, String s) {
        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (cache[i] != -1) {
            return cache[i];
        }

        // Path for choosing one digit mapping
        int result = backtrack(i + 1, s);

        if (i + 1 < s.length()) {
            if (
                codes.contains(s.substring(i, i + 2))
            ) {
                // Path for choosing a two digit mapping
                result += backtrack(i + 2, s);
            }
        }

        cache[i] = result;
        return cache[i];
    }

    public int numDecodings(String s) {
        int n = s.length();
        cache = new int[n];
        codes = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            codes.add(String.valueOf(i));
        }
        Arrays.fill(cache, -1);
        return backtrack(0, s);
    }
}
