class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()
        n = len(s)
        l = 0
        longest = 0
        for r in range(n):
            while s[r] in seen:
                seen.remove(s[l])
                l += 1

            seen.add(s[r])
            longest = max(longest, r - l + 1)
        return longest
