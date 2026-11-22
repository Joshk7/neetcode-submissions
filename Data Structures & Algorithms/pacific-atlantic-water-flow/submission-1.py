class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        m = len(heights)
        n = len(heights[0])
        def valid(r, c):
            return 0 <= r and r < m and 0 <= c and c < n
        
        def bfs(queue, ocean):
            while queue:
                r, c = queue.popleft()
                for d in directions:
                    nr = r + d[0]
                    nc = c + d[1]
                    if not valid(nr, nc):
                        continue
                    if (nr, nc) in ocean:
                        continue
                    if heights[nr][nc] < heights[r][c]:
                        continue
                    ocean.add((nr, nc))
                    queue.append((nr, nc))

        pq = deque()
        aq = deque()
        pacific = set()
        atlantic = set()
        for c in range(n):
            pq.append((0, c))
            pacific.add((0, c))
            aq.append((m - 1, c))
            atlantic.add((m - 1, c))
        
        for r in range(m):
            pq.append((r, 0))
            pacific.add((r, 0))
            aq.append((r, n - 1))
            atlantic.add((r, n - 1))
        
        bfs(pq, pacific)
        bfs(aq, atlantic)
        answer = []
        for cell in pacific:
            if cell in atlantic:
                answer.append(list(cell))
        return answer