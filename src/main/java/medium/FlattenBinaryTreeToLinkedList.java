package medium;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {

    }
    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    
    TreeNode p;

    public void flatten(TreeNode root) {
        flatten(root, false);

        TreeNode temp = root;
        while(temp!=null){
            temp.right = temp.left;
            temp.left = null;
            temp = temp.right;
        }
    }

    public void flatten(TreeNode root, boolean isRight) {
        if(root==null) return;

        if(isRight){
            p.right = root;
        }

        p = root;

        flatten(root.left, false);
        flatten(root.right, true);
    }
}
