class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 1:
            return nums[0]
            
        def dfs(i, nums, dp):
            if i >= len(nums):
                return 0
            
            if dp[i] != -1:
                return dp[i]
            
            dp[i] = max(dfs(i + 1, nums, dp), nums[i] + dfs(i + 2, nums, dp))
            return dp[i]
        
        dp1 = [-1] * (n - 1)
        dp2 = [-1] * (n - 1)
        return max(dfs(0, nums[1:], dp1), dfs(0, nums[:n - 1], dp2))