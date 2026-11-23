class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[-1] * n for _ in range(m)]

        def dfs(r, c):
            if r == m - 1 or c == n - 1:
                return 1
            
            if dp[r][c] != -1:
                return dp[r][c]
            
            dp[r][c] = dfs(r + 1, c) + dfs(r, c + 1)
            return dp[r][c]
        return dfs(0, 0)
        for r in range(m):
            dp[r][0] = 1
        
        for c in range(1, n):
            dp[0][c] = 1

        for r in range(1, m):
            for c in range(1, n):
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1]
        for r in dp:
            print(*r)
        return dp[m - 1][n - 1]
            
