class Solution {
    public int getSum(int a, int b) {
        int carry = 0, res = 0, mask = 0xFFFFFFFF;
        for (int i = 0; i < 32; i++) {
            int aBit = (a >> i) & 1;
            int bBit = (b >> i) & 1;
            int curBit = aBit ^ bBit ^ carry;
            carry = (aBit + bBit + carry) >= 2 ? 1 : 0;
            if (curBit != 0) {
                res |= (1 << i);
            }
        }

        if (res > 0x7FFFFFFF) {
            res = ~(res ^ mask);
        }

        return res;
    }
}
