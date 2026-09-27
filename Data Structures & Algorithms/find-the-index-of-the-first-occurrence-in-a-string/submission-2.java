class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i < n - m + 1; i++) {
            String substring = haystack.substring(i, i + m);
            if (needle.equals(substring)) {
                return i;
            }
        }

        return -1;
    }
}