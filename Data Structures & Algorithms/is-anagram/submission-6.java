class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for (char c : s.toCharArray()) {
            freqS[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freqT[c - 'a']++;
        }

        for (int l = 0; l < 26; l++) {
            if (freqS[l] != freqT[l]) {
                return false;
            }
        }

        return true;
    }
}
