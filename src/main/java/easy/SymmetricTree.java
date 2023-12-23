package easy;

public class SymmetricTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(543,
                        new TreeNode(384, null, new TreeNode(445)),
                        new TreeNode(652, null, new TreeNode(699)));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;

        if(root.left == null && root.right == null) return true;

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if((l == null && r != null) || (l != null && r == null)) return false;

        if(l == null && r == null) return true;

        return l.val == r.val && isSymmetric(l.right, r.left) && isSymmetric(l.left, r.right);
    }
}
