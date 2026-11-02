class Solution {
    private int[] cache;
    private Set<Character> tens;
    private Set<Character> twenties;

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
            char firstDigit = s.charAt(i);
            char secondDigit = s.charAt(i + 1);
            if (
                '1' == firstDigit && tens.contains(secondDigit) ||
                '2' == firstDigit && twenties.contains(secondDigit)
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
        tens = new HashSet<>();
        for (char c : "0123456789".toCharArray()) {
            tens.add(c);
        }

        twenties = new HashSet<>();
        for (char c : "0123456".toCharArray()) {
            twenties.add(c);
        }
        Arrays.fill(cache, -1);
        return backtrack(0, s);
    }
}
