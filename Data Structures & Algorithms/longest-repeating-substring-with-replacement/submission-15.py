class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        letters = set(s)
        longest = 0
        for c in letters:
            l = 0
            count = 0
            for r in range(len(s)):
                count += 1 if s[r] == c else 0
                if r - l + 1 - count > k:
                    count -= 1 if s[l] == c else 0
                    l += 1
                longest = max(longest, r - l + 1)
        return longest
