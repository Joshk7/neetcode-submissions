class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int n = s.length();
        int longest = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }
}
