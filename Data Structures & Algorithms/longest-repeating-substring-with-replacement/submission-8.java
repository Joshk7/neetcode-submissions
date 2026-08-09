class Solution {
    public int characterReplacement(String s, int k) {
        int[] letters = new int[26];
        int maxFreq = 0;
        int l = 0;
        int answer = 0;

        for (int r = 0; r < s.length(); r++) {
            int keyR = s.charAt(r) - 'A';
            letters[keyR]++;
            maxFreq = Math.max(maxFreq, letters[keyR]);

            while (r - l + 1 - maxFreq > k) {
                int keyL = s.charAt(l) - 'A';
                letters[keyL]--;
                l++;
            }

            answer = Math.max(answer, r - l + 1);
        }

        return answer;
    }
}
