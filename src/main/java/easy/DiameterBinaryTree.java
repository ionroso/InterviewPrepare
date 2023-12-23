package easy;

public class DiameterBinaryTree {
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
    public int diameterOfBinaryTree(TreeNode root) {
        return 0;
    }

    public int diameterOfBinaryTreeRec(TreeNode root) {
        if(root == null)
        {
            return 0;
        }

        return diameterOfBinaryTreeRec(root.left) + diameterOfBinaryTreeRec(root.right) + 1;
    }
}
