class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> letters = new HashMap<>();
        int l = 0, r = 0, n = s.length();
        int longest = 0;
        while (r < n) {
            char rKey = s.charAt(r);
            letters.put(rKey, letters.getOrDefault(rKey, 0) + 1);
            while (l < r && letters.getOrDefault(rKey, 0) > 1) {
                char lKey = s.charAt(l);
                letters.put(lKey, letters.get(lKey) - 1);
                l++;
            }
            longest = Math.max(longest, r - l + 1);

            r++;
        }

        return longest;
    }
}
