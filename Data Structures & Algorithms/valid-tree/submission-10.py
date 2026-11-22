class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        adj = [[] for i in range(n)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        seen = [False] * n
        def valid(root):
            queue = deque([(root, -1)])
            seen[root] = True
            while queue:
                node, parent = queue.popleft()
                for nei in adj[node]:
                    if nei == parent:
                        continue
                    if seen[nei]:
                        return False
                    seen[nei] = True
                    queue.append((nei, node))
            return True
        
        components = 0
        for node in range(n):
            if not seen[node]:
                components += 1
                if not valid(node):
                    return False
            if components > 1:
                return False
        return True