class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        letters = {}
        for (cs, ct) in zip(s, t):
            letters[cs] = letters.get(cs, 0) + 1
            letters[ct] = letters.get(ct, 0) - 1
        
        for letter in letters.values():
            if letter != 0:
                return False
        return True
        