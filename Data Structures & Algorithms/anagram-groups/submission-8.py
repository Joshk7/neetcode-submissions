class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = defaultdict(list)
        for s in strs:
            letters = [0] * 26
            for c in s:
                letters[ord(c) - ord('a')] += 1
            key = ",".join(str(s) for s in letters)
            anagrams[key].append(s)
        
        answer = []
        for anagram_list in anagrams.values():
            answer.append(anagram_list)
        return answer
