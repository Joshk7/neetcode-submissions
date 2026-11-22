class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        answer = 0
        for i in range(n):
            l = i
            r = i
            while 0 <= l and r < n and s[l] == s[r]:
                answer += 1
                l -= 1
                r += 1
            
            l = i
            r = i + 1
            while 0 <= l and r < n and s[l] == s[r]:
                answer += 1
                l -= 1
                r += 1
        
        return answer
            