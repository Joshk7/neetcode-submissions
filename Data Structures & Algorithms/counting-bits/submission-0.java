class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            ans[i] = count(i);
        }
        return ans;
    }

    private int count(int n) {
        int bits = 0;
        while (n > 0) {
            bits++;
            n = n & (n - 1);
        }
        return bits;
    }
}
