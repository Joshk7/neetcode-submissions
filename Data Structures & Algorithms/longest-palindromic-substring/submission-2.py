class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        answer = ""
        for i in range(n):
            l = i
            r = i
            while 0 <= l and r < n and s[l] == s[r]:
                l -= 1
                r += 1
            if r - l > len(answer):
                answer = s[l + 1:r]
        
        for i in range(n - 1):
            l = i
            r = i + 1
            while 0 <= l and r < n and s[l] == s[r]:
                l -= 1
                r += 1
            if r - l > len(answer):
                answer = s[l + 1:r]

        return answer