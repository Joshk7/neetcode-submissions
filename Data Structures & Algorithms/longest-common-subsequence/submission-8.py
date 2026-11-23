class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        m = len(text1)
        n = len(text2)
        cache = [0] * (n + 1)
        for r in range(m - 1, -1, -1):
            cur = [0] * (n + 1)
            for c in range(n - 1, -1, -1):
                cur[c] = max(cache[c], cur[c + 1])
                if text1[r] == text2[c]:
                    cur[c] = max(cur[c], 1 + cache[c + 1])
            cache = cur
        return cache[0]