class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (longest.length() > j - i + 1) continue;
                if (isPalindrome(i, j, s)) {
                    longest = s.substring(i, j + 1);
                }
            }
        }
        return longest;
    }

    private boolean isPalindrome(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
