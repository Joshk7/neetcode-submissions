class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        m = len(board)
        n = len(board[0])
        visited = [[False] * n for r in range(m)]

        def valid(r, c):
            return 0 <= r and r < m and 0 <= c and c < n

        def dfs(r, c, i):
            if i == len(word):
                return True
            
            if not valid(r, c):
                return False

            if visited[r][c]:
                return False
            
            if board[r][c] != word[i]:
                return False
            
            visited[r][c] = True
            for d in directions:
                nr = r + d[0]
                nc = c + d[1]
                if dfs(nr, nc, i + 1):
                    return True
            visited[r][c] = False
            return False
        
        for r in range(m):
            for c in range(n):
                if dfs(r, c, 0):
                    return True
        return False