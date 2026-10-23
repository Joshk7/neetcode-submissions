class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = "";
        for (int i = 0; i < n; i++) {
            String current = findLongestPalindrome(i, i, s);
            if (current.length() > longest.length()) {
                longest = current;
            }
        }

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) != s.charAt(i)) continue;
            String current = findLongestPalindrome(i - 1, i, s);
            if (current.length() > longest.length()) {
                longest = current;
            }
        }

        return longest;
    }

    private String findLongestPalindrome(int l, int r, String s) {
        while (l - 1 >= 0 && r + 1 < s.length() && s.charAt(l - 1) == s.charAt(r + 1)) {
            l--;
            r++;
        }
        return s.substring(l, r + 1);
    }
}
