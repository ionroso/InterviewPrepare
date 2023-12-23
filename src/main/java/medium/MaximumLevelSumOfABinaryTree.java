package medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root);

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1, level = 1;

        while (!queue1.isEmpty()){
            Queue<TreeNode> queue2 = new LinkedList<>();
            while (!queue1.isEmpty()){
                TreeNode poll = queue1.poll();
                sum+=poll.val;

                if(poll.left != null){
                    queue2.offer(poll.left);
                }
                if(poll.right != null){
                    queue2.offer(poll.right);
                }
            }

            if(maxSum < sum){
                maxSum = sum;
                maxLevel = level;
            }
            queue1=queue2;
            level++;
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode twoHundreds = new TreeNode(-200);
        twoHundreds.left = new TreeNode(-20);
        twoHundreds.right = new TreeNode(-5);

        TreeNode threeHundreds = new TreeNode(-300);
        threeHundreds.left = new TreeNode(-10);

        TreeNode root = new TreeNode(-100);
        root.left = twoHundreds;
        root.right = threeHundreds;

        System.out.println(new MaximumLevelSumOfABinaryTree().maxLevelSum(root));
    }
}
