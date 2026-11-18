class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        letters = [0] * 26
        longest = 0
        maxF = 0
        n = len(s)
        l = 0
        for r in range(n):
            right = ord(s[r]) - ord('A')
            letters[right] += 1
            maxF = max(maxF, letters[right])
            while r - l + 1 - maxF > k:
                left = ord(s[l]) - ord('A')
                letters[left] -= 1
                l += 1
            longest = max(longest, r - l + 1)
        return longest