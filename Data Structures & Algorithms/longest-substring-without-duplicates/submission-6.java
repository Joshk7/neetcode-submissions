class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int longest = 0;
        for (int i = 0; i < n; i++) {
            if (n - i + 1 <= longest) continue;
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (seen.contains(s.charAt(j))) {
                    break;
                }
                seen.add(s.charAt(j));
                longest = Math.max(longest, j - i + 1);
            }
        }
        return longest;
    }
}
