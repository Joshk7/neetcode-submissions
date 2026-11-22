class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [-1] * (n + 1) 

        def dfs(i):
            if i <= 0:
                return 1
            
            if i == 1:
                return 1
            
            if dp[i] != -1:
                return dp[i]
            
            dp[i] = dfs(i - 1) + dfs(i - 2)
            return dp[i]
        
        return dfs(n)