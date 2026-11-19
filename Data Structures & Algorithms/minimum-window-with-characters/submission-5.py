class Solution:
    def minWindow(self, s: str, t: str) -> str:
        target = {}
        keys = 0
        for c in t:
            target[c] = target.get(c, 0) + 1
            if target[c] == 1:
                keys += 1

        minimum = s + '#'
        window = {}
        matching = 0
        l = 0
        for r in range(len(s)):
            window[s[r]] = window.get(s[r], 0) + 1
            if s[r] in target and window[s[r]] == target[s[r]]:
                matching += 1
            while matching == keys:
                if r - l + 1 < len(minimum):
                    minimum = s[l:r + 1]
                window[s[l]] -= 1
                if s[l] in target and window[s[l]] + 1 == target[s[l]]:
                    matching -= 1
                l += 1
        
        return "" if minimum == s + '#' else minimum
