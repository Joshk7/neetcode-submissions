class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        grid = grid
        m = len(grid)
        n = len(grid[0])

        def valid(r, c):
            nonlocal m, n
            return 0 <= r and r < m and 0 <= c and c < n
        
        def dfs(r, c):
            grid[r][c] = "0"
            for d in directions:
                nr = r + d[0]
                nc = c + d[1]
                if not valid(nr, nc):
                    continue
                if grid[nr][nc] == "0":
                    continue
                dfs(nr, nc)

        islands = 0
        for r in range(m):
            for c in range(n):
                if grid[r][c] == "1":
                    islands += 1
                    dfs(r, c)
        return islands
        