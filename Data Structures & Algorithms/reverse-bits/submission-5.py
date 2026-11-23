class Solution:
    def reverseBits(self, n: int) -> int:
        reverse = 0
        for i in range(32):
            reverse <<= 1
            reverse |= 1 & n
            n >>= 1
        return reverse 