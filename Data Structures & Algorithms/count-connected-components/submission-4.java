class Solution {

    int[] parent;
    int[] rank;

    int find(int n) {
        int p = parent[n];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) {
            return false;
        }

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1]++;
        } else {
            parent[p1] = p2;
            rank[p2]++;
        }

        return true;
    }

    public int countComponents(int n, int[][] edges) {
        this.parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        this.rank = new int[n];
        Arrays.fill(rank, 1);

        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                n--;
            }
        }

        return n;
    }
}
