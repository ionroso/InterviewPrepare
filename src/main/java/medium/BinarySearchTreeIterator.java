package medium;

import java.util.Stack;

public class BinarySearchTreeIterator {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
//        new BinarySearchTreeIterator().inOrder(root);
        BinarySearchTreeIterator.BSTIterator bstIterator = new BinarySearchTreeIterator.BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }

    void inOrder(TreeNode root){
        TreeNode h = root;
        Stack<TreeNode> stack = new Stack<>();
        while (h != null || !stack.isEmpty()){
            while (h!=null) {
                stack.add(h);
                h = h.left;
            }

            h = stack.pop();
            System.out.println(h.val);
            h = h.right;
        }
    }
    static class BSTIterator {

        private TreeNode head;
        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.head = root;
            this.stack = new Stack<>();

            while (head!=null) {
                stack.add(head);
                head = head.left;
            }
        }

        public int next() {
            head = stack.pop();

            int rez = head.val;
            head = head.right;
            while (head!=null) {
                stack.add(head);
                head = head.left;
            }
            return rez;
        }

        public boolean hasNext() {
            return stack.isEmpty() || head == null;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
