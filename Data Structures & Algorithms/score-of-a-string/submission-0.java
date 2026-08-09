class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            int left = s.charAt(i - 1);
            int right = s.charAt(i);
            score += Math.abs(left - right);
        }
        return score;
    }
}