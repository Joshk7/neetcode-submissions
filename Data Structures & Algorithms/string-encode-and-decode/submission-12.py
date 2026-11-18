class Solution:

    def encode(self, strs: List[str]) -> str:
        arr = []
        for s in strs:
            l = len(s)
            arr.append(f"{l}#{s}")
        return "".join(arr)

    def decode(self, s: str) -> List[str]:
        arr = []
        i = 0
        while i < len(s):
            j = i
            while s[j] != '#':
                j += 1
            size = int(s[i:j])
            arr.append(s[j + 1:j + size + 1])
            i = j + size + 1
        return arr
            