package medium;

public class NumberOfConnectedComponentsUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        UnionFindSimplified union = new UnionFindSimplified(n);
        for (int i = 0; i < edges.length; i++) {
            union.unify(edges[i][0],edges[i][1]);
        }

        return union.numComponents;
    }

    static class UnionFindSimplified {

        private int[] id;

        private int numComponents;

        public UnionFindSimplified(int size) {

            if (size <= 0) throw new IllegalArgumentException("Size <= 0 is not allowed");

            numComponents = size;
            id = new int[size];

            for (int i = 0; i < size; i++) {
                id[i] = i;
            }
        }

        public int find(int p) {
            int root = p;
            while (root != id[root]) root = id[root];

            return root;
        }

        public void unify(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);
            if (root1 == root2) return;

            id[root1] = root2;
            numComponents--;
        }
    }
}
