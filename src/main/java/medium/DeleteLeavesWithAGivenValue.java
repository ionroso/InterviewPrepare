package medium;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteLeavesWithAGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null) return null;

        DFS(root, root.left, target);
        DFS(root, root.right, target);

        if(root.left!=null || root.right!=null) return root;

        return root.val != target ? root : null;
    }

    private void DFS(TreeNode parent, TreeNode child, int target) {
        if(child==null) return;

        if(child.left!=null){
            DFS(child, child.left, target);
        }

        if(child.right!=null){
            DFS(child, child.right, target);
        }

        if(child.left == null && child.right == null && child.val == target){
            if(parent.left == child) parent.left=null;
            if(parent.right == child) parent.right=null;
        }
    }


    class TreeNode {
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
}
