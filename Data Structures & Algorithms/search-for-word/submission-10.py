class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        m = len(board)
        n = len(board[0])

        def valid(r, c):
            return 0 <= r and r < m and 0 <= c and c < n

        def dfs(r, c, i):
            if i == len(word):
                return True
            
            if not valid(r, c):
                return False
            
            if board[r][c] != word[i]:
                return False
            
            board[r][c] = '#'
            res = False
            for d in directions:
                nr = r + d[0]
                nc = c + d[1]
                res = res or dfs(nr, nc, i + 1)
            board[r][c] = word[i]
            return res
        
        for r in range(m):
            for c in range(n):
                if dfs(r, c, 0):
                    return True
        return False