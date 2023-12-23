package medium;

import java.util.HashSet;
import java.util.Set;

public class FindElementsInAContaminatedBinaryTree {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
        }

        private class TreeNode {
            int val;
            TreeNode left, right;

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }


        private class FindElements {

            Set<Integer> cache;

            public FindElements(TreeNode root) {
                this.cache = new HashSet<>();

                recover(root, 0, cache);
            }

            private void recover(TreeNode root, int x, Set<Integer> cache){
                if(root == null) {
                    return;
                }

                cache.add(x);

                if(root.left!=null){
                    recover(root.left, 2 * x + 1, cache);
                }
                if(root.left!=null){
                    recover(root.right, 2 * x + 2, cache);
                }
            }

            public boolean find(int target) {
                return cache.contains(target);
            }
        }

    }
}
