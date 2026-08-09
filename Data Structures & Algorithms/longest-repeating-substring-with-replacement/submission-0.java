class Solution {
    public int characterReplacement(String s, int k) {
        int answer = 0;
        int[] letters = new int[26];
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int rKey = s.charAt(r) - 'A';
            letters[rKey]++;
            int maxCount = 0;
            for (int letter : letters) {
                maxCount = Math.max(maxCount, letter);
            }

            while (r - l + 1 - maxCount > k) {
                int lKey = s.charAt(l) - 'A';
                letters[lKey]--;
                l++;
            }

            answer = Math.max(answer, r - l + 1);
        }

        return answer;
    }
}
