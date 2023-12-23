package medium;

public class MapSumPairs {

    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            MapSum mapSum = new MapSum();
            mapSum.insert("a", 3);
            mapSum.sum("ap");           // return 3 (apple = 3)
            mapSum.insert("b", 2);
            mapSum.sum("a");           // return 5 (apple + app = 3 + 2 = 5)
        }


       private class Trie {
            int val = 0;

            Trie[] nodes; // 26 lowercase letter code to Trie, 'a' - 0, 'b' - 1, ..., 'z' - 25

           Trie(){
               nodes = new Trie[26];
           }
        }

        private class MapSum {

            Trie root;

            public MapSum() {
                root = new Trie();

            }

            public void insert(String key, int val) {
                insert(root, key, 0, val);
            }

            public int sum(String prefix) {
                Trie temp = getStartFromNode(root, prefix, 0);
                return getSum(temp, prefix, 0);
            }

            private Trie getStartFromNode(Trie root, String prefix, int index) {
                if(root==null){
                    return null;
                }

                Trie node = root.nodes[prefix.charAt(index)-'a'];

                if(index == prefix.length()-1){
                    return node;
                }

                return getStartFromNode(node, prefix, index + 1);
            }

            private int getSum(Trie root, String prefix, int index) {
                if(root == null) {
                    return 0;
                }

                int sum = root.val;
                for (Trie node : root.nodes) {
                    if(node != null){
                        sum += getSum(node, prefix, index+1);
                    }
                }

                return sum;
            }

            private void insert(Trie root, String key, int index, int val) {
                if (root == null){
                    return;
                }

                Trie node = root.nodes[key.charAt(index)-'a'];
                if(node == null){
                    node = new Trie();
                    root.nodes[key.charAt(index)-'a'] = node;
                }

                if(index == key.length()-1){
                    node.val = val;
                    return;
                }

                insert(node, key, index+1, val);
            }
        }
    }
}
