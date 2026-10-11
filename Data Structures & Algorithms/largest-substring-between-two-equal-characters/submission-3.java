class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] letters = new int[26];
        Arrays.fill(letters, -1);

        int n = s.length();
        int ans = -1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (letters[c - 'a'] != -1) {
                ans = Math.max(ans, i - letters[c - 'a'] - 1);
            } else {
                letters[c - 'a'] = i;
            }
        }
        return ans;
    }
}