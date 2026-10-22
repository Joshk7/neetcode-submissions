class DSU {
    private int[] Parent;
    private int[] Size;
    private int Components;

    public DSU(int n) {
        Parent = new int[n];
        Size = new int[n];
        Components = n;
        for (int i = 0; i < n; i++) {
            Parent[i] = i;
            Size[i] = 1;
        }
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
        if (Size[pu] > Size[pv]) {
            Size[pu] += Size[pv];
            Parent[pv] = pu;
        } else {
            Size[pv] += Size[pu];
            Parent[pu] = pv;
        }
        Components--;
        return true;
    }

    public int getComponents() {
        return Components;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!dsu.union(u, v)) {
                return edge;
            }
        }

        return edges[n - 1];
    }
}
