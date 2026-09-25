class Solution {
    public int minimumRecolors(String blocks, int k) {
        int res = blocks.length();
        for (int i = 0; i <= blocks.length() - k; i++) {
            int white = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    white++;
                }
            }
            res = Math.min(res, white);
        }
        return res;
    }
}