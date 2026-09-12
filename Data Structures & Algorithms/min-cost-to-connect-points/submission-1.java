class UnionFind {
    int[] Parent, Size;

    public UnionFind(int n) {
        Parent = new int[n + 1];
        Size = new int[n + 1];
        for (int i = 0; i <= n; i++) Parent[i] = i;
        Arrays.fill(Size, 1);
    }

    public int find(int node) {
        if (Parent[node] != node) {
            Parent[node] = find(Parent[node]);
        }
        return Parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;
        if (Size[pu] < Size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        Size[pu] += Size[pv];
        Parent[pv] = pu;
        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            int x1 = p1[0];
            int y1 = p1[1];
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                int x2 = p2[0];
                int y2 = p2[1];

                int distance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                edges.add(new int[]{distance, i, j});
            }
        }

        edges.sort((a, b) -> Integer.compare(a[0], b[0]));
        UnionFind uf = new UnionFind(n);
        int cost = 0;

        for (int[] edge : edges) {
            int distance = edge[0];
            int p1 = edge[1];
            int p2 = edge[2];
            if (uf.union(p1, p2)) {
                cost += distance;
            }
        }

        return cost;
    }
}
