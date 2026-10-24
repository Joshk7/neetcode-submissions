class Solution {
    public int minDeletions(String s) {
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        Arrays.sort(letters);
        int limit = s.length(), ans = 0;
        for (int i = 25; i >= 0; i--) {
            int keep = Math.min(letters[i], limit);
            ans += letters[i] - keep; limit = Math.max(0, keep - 1);
        }

        return ans;
    }
}
