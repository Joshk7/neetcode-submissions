class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        adj = {c: set() for w in words for c in w}
        n = len(words)
        for i in range(1, n):
            a, b = words[i - 1], words[i]
            min_len = min(len(a), len(b))
            if len(a) > len(b) and a[:min_len] == b[:min_len]:
                return ""
            for j in range(min(len(a), len(b))):
                if a[j] != b[j]:
                    adj[a[j]].add(b[j])
                    break
            
        visited = {}
        res = []

        def dfs(c):
            if c in visited:
                return visited[c]
            
            visited[c] = True

            for nei in adj[c]:
                if dfs(nei):
                    return True

            visited[c] = False
            res.append(c)
        
        for c in adj:
            if dfs(c):
                return ""
        
        res.reverse()
        return "".join(res)
        
