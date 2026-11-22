class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 0:
            return n
        one = 0
        two = 1
        for i in range(n):
            tmp = one + two
            one = two
            two = tmp
        return two