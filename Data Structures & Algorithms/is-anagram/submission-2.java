class Solution {
    public boolean isAnagram(String s, String t) {
        int[] letters = new int[26];

        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            letters[c - 'a']--;
        }

        for (int letter : letters) {
            if (letter != 0) {
                return false;
            }
        }

        return true;
    }
}
