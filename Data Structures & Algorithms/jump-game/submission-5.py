class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [False] * n
        dp[n - 1] = True
        for i in range(n - 1, -1, -1):
            max_jump = min(i + nums[i] + 1, n)
            for j in range(max_jump - 1, i, -1):
                if dp[j]:
                    dp[i] = True
                    break

        return dp[0]