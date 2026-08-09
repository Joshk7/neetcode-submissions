class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int n = s.length();
        int[] letters = new int[26];
        int l = 0;
        int maxf = 0;
        for (int r = 0; r < n; r++) {
            int keyR = s.charAt(r) - 'A';
            letters[keyR]++;
            maxf = Math.max(maxf, letters[keyR]);
            while ((r - l + 1) - maxf > k) {
                int keyL = s.charAt(l) - 'A';
                letters[keyL]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
