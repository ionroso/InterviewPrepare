package medium;

public class LongestUploadedPrefix {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            LUPrefix server = new LUPrefix(4);   // Initialize a stream of 4 videos.
            server.upload(3);                    // Upload video 3.
            // So, we return 0.
            server.upload(1);                    // Upload video 1.
            server.upload(2);                    // Upload video 2.
            server.longest();                    // The prefix [1,2,3] is the longest uploaded prefix, so we return 3.
        }

         class LUPrefix {
            int n;

            UnionFind uf;
            boolean[] videos;

            public LUPrefix(int n) {
                this.n = n;
                this.videos = new boolean[n];
                this.uf = new UnionFind(n);
            }

            public void upload(int video) {
                int videoId = getID(video);

                videos[videoId] = true;
                if(videoId!=0 && videos[videoId-1]){
                    uf.unify(videoId-1, videoId);
                }
                if(videoId<n-1 && videos[videoId+1]){
                    uf.unify(videoId, videoId+1);
                }
            }

            public int longest() {
                if(!videos[0]){
                    return 0;
                }

                int root = uf.find(0);
                return  uf.componentSize(root);
            }

            public int getID(int id) {
                return id-1;
            }
        }

        private class UnionFind {
            private int size;
            private int componentsCount;

            private int[] union;
            private int[] unionSize;

            public UnionFind(int size) {
                this.size = size;
                this.componentsCount = size;
                this.union = new int[size];
                this.unionSize = new int[size];

                for (int i = 0; i < size; i++) {
                    union[i] = i;
                    unionSize[i] = 1;
                }
            }

            public int find(int root){
                while (root != union[root]){
                    root = union[root];
                }

                return root;
            }

            public boolean unify(int c1, int c2){
                int c1Rep = find(c1);
                int c2Rep = find(c2);

                if(c1Rep == c2Rep) {
                    return false;
                }

                if(unionSize[c1Rep] >= unionSize[c2Rep]){
                    union[c2Rep] = c1Rep;
                    unionSize[c1Rep] += unionSize[c2Rep];
                } else {
                    union[c1Rep] = c2Rep;
                    unionSize[c2Rep] += unionSize[c1Rep];
                }

                return true;
            }

            public int componentSize(int c) {
                return unionSize[c];
            }
        }
    }
}
