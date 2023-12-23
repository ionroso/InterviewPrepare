package easy;

import java.util.Map;
import java.util.Stack;

public class MinimumAbsoluteDifferenceBST {

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

        getMinimumDifference(root);
    }
    public static int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, prev = null;
        int minAbs = Integer.MAX_VALUE;
        while (curr!=null || !stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if(prev == null) {
                prev = curr;
            } else {
                minAbs = Math.min(minAbs, curr.val - prev.val);
                prev = curr;
            }

            curr = curr.right;
        }

        return minAbs;
    }

}
