class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        dp = [0] * (n + 1)
        dp[n] = 1
        for i in range(n - 1, -1, -1):
            if s[i] == '0':
                continue
            dp[i] = dp[i + 1]
            if i + 1 < n:
                ten = int(s[i])
                one = int(s[i + 1])
                if (
                    (ten == 1 and 0 <= one and one <= 9) or 
                    (ten == 2 and 0 <= one and one <= 6)
                ):
                   dp[i] += dp[i + 2]

        return dp[0]

        def dfs(i):
            if i >= n:
                return 1
            
            if s[i] == '0':
                return 0

            if dp[i] != -1:
                return dp[i]
            
            res = dfs(i + 1)
            if i + 1 < n:
                ten = int(s[i])
                one = int(s[i + 1])
                if (
                    (ten == 1 and 0 <= one and one <= 9) or 
                    (ten == 2 and 0 <= one and one <= 6)
                ):
                   res += dfs(i + 2)
            
            dp[i] = res
            return dp[i]
        
        return dfs(0)