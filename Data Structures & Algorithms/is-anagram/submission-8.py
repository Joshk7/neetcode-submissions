class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        letters = [0] * 26
        for (cs, ct) in zip(s, t):
            letters[ord(cs) - ord('a')] += 1
            letters[ord(ct) - ord('a')] -= 1
        
        for letter in letters:
            if letter != 0:
                return False
        return True
        