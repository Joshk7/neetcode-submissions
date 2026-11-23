class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        m = len(text1)
        n = len(text2)
        cache = [[0] * (n + 1) for _ in range(m + 1)]
        for r in range(m - 1, -1, -1):
            for c in range(n - 1, -1, -1):
                cache[r][c] = max(cache[r + 1][c], cache[r][c + 1])
                if text1[r] == text2[c]:
                    cache[r][c] = max(cache[r][c], 1 + cache[r + 1][c + 1])
        return cache[0][0]


        def dfs(r, c):
            if r == m or c == n:
                return 0
            
            if cache[r][c] != -1:
                return cache[r][c]
            
            result = max(dfs(r + 1, c), dfs(r, c + 1))
            if text1[r] == text2[c]:
                result = max(result, 1 + dfs(r + 1, c + 1))
            cache[r][c] = result
            return result

        answer = dfs(0, 0)
        for r in cache:
            print(*r)
        return dfs(0, 0)