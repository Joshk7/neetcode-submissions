class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[-1] * (n - 1) for _ in range(m - 1)]

        def dfs(r, c):
            if r == m - 1 or c == n - 1:
                return 1
            
            if dp[r][c] != -1:
                return dp[r][c]
            
            dp[r][c] = dfs(r + 1, c) + dfs(r, c + 1)
            return dp[r][c]
        return dfs(0, 0)
            
