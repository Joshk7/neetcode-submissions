class Solution {
    public String customSortString(String order, String s) {
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (letters[c - 'a'] > 0) {
                sb.append(c);
                letters[c - 'a']--;
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            while (letters[c - 'a'] > 0) {
                sb.append(c);
                letters[c - 'a']--;
            }
        }

        return sb.toString();
    }
}