class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        dp = [[False] * n for _ in range(n)]
        answer = 0
        for r in range(n - 1, -1, -1):
            for c in range(r, n):
                if s[c] == s[r] and ((c - r) <= 2 or dp[r + 1][c - 1]):
                    dp[r][c] = True
                    answer += 1
        return answer
            