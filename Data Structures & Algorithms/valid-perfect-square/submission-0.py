class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        l = 1
        r = num
        while l <= r:
            m = l + (r - l) // 2
            square = m * m
            if square < num:
                l = m + 1
            elif square > num:
                r = m - 1
            else:
                return True
        return False

