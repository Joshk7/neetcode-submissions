class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        grid = grid
        m = len(grid)
        n = len(grid[0])

        def valid(r, c):
            nonlocal m, n
            return 0 <= r and r < m and 0 <= c and c < n
        
        def bfs(r, c):
            queue = deque([(r, c)])
            grid[r][c] = '0'
            while queue:
                tr, tc = queue.popleft()
                for d in directions:
                    nr = tr + d[0]
                    nc = tc + d[1]
                    if not valid(nr, nc):
                        continue
                    if grid[nr][nc] == '0':
                        continue
                    grid[nr][nc] = '0'
                    queue.append((nr, nc))

        islands = 0
        for r in range(m):
            for c in range(n):
                if grid[r][c] == "1":
                    islands += 1
                    bfs(r, c)
        return islands
        