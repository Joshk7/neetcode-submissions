class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int ps = 0;
        int pt = 0;

        while (ps < n && pt < m) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
            }

            pt++;
        }

        return ps == n;
    }
}