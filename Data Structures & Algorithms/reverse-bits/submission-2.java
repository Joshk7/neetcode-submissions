class Solution {
    public int reverseBits(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            reverse += (bit << (31 - i));
        }
        return reverse;
    }
}
