class Solution:
    def mySqrt(self, x: int) -> int:
        if x <= 1:
            return x
        
        l = 2
        r = x // 2
        ans = 0
        while l <= r:
            m = l + (r - l) // 2
            square = m * m
            if square > x:
                r = m - 1
            elif square < x:
                l = m + 1
            else:
                return m

        return r