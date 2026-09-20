class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();

        int[] res = new int[n];
        int moves = 0, balls = 0;
        for (int i = 0; i < n; i++) {
            res[i] += moves + balls;
            moves = moves + balls;
            balls = balls + (boxes.charAt(i) == '1' ? 1 : 0);
        }

        moves = balls = 0;
        for (int i = n - 1; i >= 0; i--) {
            res[i] += moves + balls;
            moves += balls;
            balls = balls + (boxes.charAt(i) == '1' ? 1 : 0);
        }

        return res;
    }
}