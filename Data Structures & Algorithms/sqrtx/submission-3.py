class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x
        l = 2
        r = x // 2
        while l <= r:
            m = l + (r - l) // 2
            squared = m * m
            if squared > x:
                r = m - 1
            elif squared < x:
                l = m + 1
            else:
                return m

        return r