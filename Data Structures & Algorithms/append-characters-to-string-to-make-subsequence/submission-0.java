class Solution {
    public int appendCharacters(String s, String t) {
        int n = s.length();
        int m = t.length();
        int ps = 0;
        int pt = 0;

        while (ps < n && pt < m) {
            if (t.charAt(pt) == s.charAt(ps)) {
                pt++;
            }

            ps++;
        }

        return m - pt;
    }
}