class Solution:
    def mySqrt(self, x: int) -> int:
        l = 0
        r = x
        while l <= r:
            m = l + (r - l) // 2
            squared = m * m
            print(f"Left: {l}, Right: {r}, Middle: {m}, Squared: {squared}")
            if squared > x:
                r = m - 1
            elif squared < x:
                l = m + 1
            else:
                return m

        return r