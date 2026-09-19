class DSU {
    private int[] parent, rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(rank, 1);
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;

        if (rank[pv] > rank[pu]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }

        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }
}

class Solution {
    private int n;
    private int idx(int r, int c) {
        return r * n + c + 1;
    }

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        DSU dsu = new DSU(n * n + 1);
        Queue<int[]> q = new LinkedList<>();

        int firstIsland = -1;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    firstIsland = dsu.find(idx(r, c));
                    if (c + 1 < n && grid[r][c + 1] == 1) {
                        dsu.union(idx(r, c), idx(r, c + 1));
                    }

                    if (r + 1 < n && grid[r + 1][c] == 1) {
                        dsu.union(idx(r, c), idx(r + 1, c));
                    }
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1 && dsu.find(idx(r, c)) == firstIsland) {
                    for (int[] d : direct) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0) {
                            q.offer(new int[]{r, c});
                            break;
                        }
                    }
                }
            }
        }

        int res = 0;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];

                for (int[] d : direct) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                        if (grid[nr][nc] == 1 && dsu.union(idx(r, c), idx(nr, nc))) {
                            return res;
                        }

                        if (grid[nr][nc] == 0) {
                            grid[nr][nc] = 1;
                            dsu.union(idx(r, c), idx(nr, nc));
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            }

            res++;
        }

        return res;
    }
}