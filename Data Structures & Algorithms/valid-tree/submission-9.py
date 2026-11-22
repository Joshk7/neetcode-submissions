class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        adj = [[] for i in range(n)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        seen = [False] * n
        def valid(node, parent):
            if seen[node]:
                return False
            
            seen[node] = True
            for nei in adj[node]:
                if nei == parent:
                    continue
                if not valid(nei, node):
                    return False
            return True
        
        components = 0
        for node in range(n):
            if not seen[node]:
                components += 1
                if not valid(node, -1):
                    return False
            if components > 1:
                return False
        return True