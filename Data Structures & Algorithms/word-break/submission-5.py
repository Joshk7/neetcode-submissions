class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        words = set(wordDict)
        n = len(s)
        dp = [False] * (n + 1)
        dp[n] = True
        for i in range(n - 1, -1, -1):
            for j in range(i, n):
                if s[i:j + 1] in words:
                    dp[i] |= dp[j + 1]
        return dp[0]
