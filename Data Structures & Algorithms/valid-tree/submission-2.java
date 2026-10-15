class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int m = edges.length;

        if (m != n-1)
            return false;

        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            if (!uf.union(x, y))
                return false;
        }
        return true;
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int components;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i=0; i<n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }

            components = n;
        }

        public boolean union(int x, int y) {
            int parX = find(x);
            int parY = find(y);

            if (parX == parY)
                return false;
            
            if (rank[parX] > rank[parY]) {
                parent[parY] = parX;
            } else if (rank[parY] < rank[parX]) {
                parent[parX] = parY;
            } else {
                parent[parY] = parX;
                rank[parX] += 1;
            }

            components--;
            return true;
        }

        public int find(int x) {
            if (x == parent[x])
                return x;
            
            return parent[x] = find(parent[x]);
        }

        public int numOfComponents() {
            return components;
        }
    }


}
