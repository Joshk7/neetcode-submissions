class DSU:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.size = [1] * n
    
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
            self.parent[pv] = pu
        else:
            self.size[pv] += self.size[pu]
            self.parent[pu] = pv
        return True

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        m, n = len(grid), len(grid[0])
        dsu = DSU(m * n)
        island = 0
        def valid(r, c):
            return 0 <= r and r < m and 0 <= c and c < n
        for r in range(m):
            for c in range(n):
                if grid[r][c] == '0':
                    continue
                island += 1
                for d in directions:
                    nr = r + d[0]
                    nc = c + d[1]
                    if not valid(nr, nc):
                        continue
                    if grid[nr][nc] == '0':
                        continue
                    if dsu.union(r * n + c, nr * n + nc):
                        island -= 1
        return island

        