class Solution {
    public int minimumLength(String s) {
        int l = 0, r = s.length();
        while (l + 1 < r && s.charAt(l) == s.charAt(r - 1)) {
            char c = s.charAt(l);
            while (l < r && s.charAt(l) == c) l++;
            while (l < r && s.charAt(r - 1) == c) r--;
        }
        return r - l;
    }
}
