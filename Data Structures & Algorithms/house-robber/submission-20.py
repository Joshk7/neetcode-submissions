class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        
        dp = [-1] * n
        def dfs(i):
            if i >= n:
                return 0
            
            if dp[i] != -1:
                return dp[i]
            
            dp[i] = max(dfs(i + 1), nums[i] + dfs(i + 2))
            return dp[i]
        ans = dfs(0)
        print(dp)
        return ans