class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [-1] * n
        def dfs(i):            
            if dp[i] != -1:
                return dp[i]
            maximum = 0
            for j in range(i + 1, n):
                if nums[i] < nums[j]:
                    maximum = max(maximum, dfs(j))
            dp[i] = maximum + 1
            return dp[i]
        
        answer = 1
        for i in range(n):
            if dp[i] == -1:
                answer = max(answer, dfs(i))
        return answer