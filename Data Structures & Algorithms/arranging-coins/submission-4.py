class Solution:
    def arrangeCoins(self, n: int) -> int:
        if n <= 3:
            return n if n == 1 else n - 1

        l = 1
        r = n
        while l < r:
            m = l + (r - l) // 2
            coins = (m * (m + 1)) / 2
            if coins > n:
                r = m
            else:
                l = m + 1
        return l - 1