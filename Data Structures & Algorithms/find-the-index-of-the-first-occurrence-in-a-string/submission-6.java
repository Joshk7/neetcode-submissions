class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int m = needle.length();
        int[] lps = new int[m];
        int prevLPS = 0, i = 1;

        while (i < m) {
            if (needle.charAt(i) == needle.charAt(prevLPS)) {
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            } else if (prevLPS == 0) {
                lps[i] = 0;
                i++;
            } else {
                prevLPS = lps[prevLPS - 1];
            }
        }

        i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }

            if (j == m) {
                return i - m;
            }
        }

        return -1;
    }
}