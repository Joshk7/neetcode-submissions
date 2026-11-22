class DSU:

    def __init__(self, n):
        self.size = [1] * n
        self.parent = [i for i in range(n)]
        self.components = n
    
    def find(self, u):
        if self.parent[u] != u:
            self.parent[u] = self.find(self.parent[u])
        return self.parent[u]
    
    def union(self, u, v):
        pu, pv = self.find(u), self.find(v)
        if pu == pv:
            return False
        if self.size[pu] >= self.size[pv]:
            self.size[pu] += self.size[pv]
            self.parent[pv] = self.parent[pu]
        else:
            self.size[pv] += self.size[pu]
            self.parent[pu] = self.parent[pv]
        self.components -= 1
        return True
    
    def components(self):
        return self.components

class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        dsu = DSU(n)
        for u, v in edges:
            dsu.union(u, v)
        return dsu.components
        