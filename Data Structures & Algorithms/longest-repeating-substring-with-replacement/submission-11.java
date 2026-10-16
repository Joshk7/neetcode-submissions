class Solution {
    public int characterReplacement(String s, int k) {
        int[] f = new int[26];
        int res = 0;

        int l = 0, maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            f[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, f[s.charAt(r) - 'A']);
            while (r - l + 1 - maxf > k) {
                f[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
