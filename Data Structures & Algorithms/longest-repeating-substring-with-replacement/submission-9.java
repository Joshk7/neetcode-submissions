class Solution {
    public int characterReplacement(String s, int k) {
        int[] letters = new int[26];

        int l = 0, r = 0, ans = 0, n = s.length();
        while (r < n) {
            letters[s.charAt(r) - 'A']++;
            int max = 0;
            for (char letter = 'A'; letter <= 'Z'; letter++) {
                max = Math.max(max, letters[letter - 'A']);
            }
            while (r - l + 1 - max > k) {
                letters[s.charAt(l) - 'A']--;
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
