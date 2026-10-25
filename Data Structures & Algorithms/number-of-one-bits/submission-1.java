class Solution {
    public int hammingWeight(int n) {
        int bits = 0;
        while (n > 0) {
            bits += n & 1;
            n = n >> 1;
        }
        return bits;
    }
}
