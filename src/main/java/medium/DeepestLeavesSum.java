package medium;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public static void main(String[] args) {
        TreeNode test = strArrayToTree("1,1,1,2,null,2,null");
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(test));
    }

    class Sum {
        int level = 0;
        int sum = 0;
    }

    public int deepestLeavesSum(TreeNode root) {
        Sum sum = new Sum();
        deepestLeavesSumRec(root, sum, 0);
        return sum.sum;
    }

    private void deepestLeavesSumRec(TreeNode root, Sum sum,  int h) {
        if(root == null) return;

        if(sum.level == h) {
            sum.sum+=root.val;
        } else if(sum.level<h){
            sum.level = h;
            sum.sum = root.val;
        }

        deepestLeavesSumRec(root.left, sum, h+1);
        deepestLeavesSumRec(root.right, sum, h+1);
    }


    public int deepestLeavesSum1(TreeNode root) {
        return deepestLeavesSumRec1(root, 0, getMaxHeight(root,-1));
    }

    int getMaxHeight(TreeNode root, int h){
        if(root == null) return h;

        return Math.max(getMaxHeight(root.left, h+1), getMaxHeight(root.right, h+1));
    }

    int deepestLeavesSumRec1(TreeNode root, int currH, int h){
        if(root == null) return 0;

        if(currH==h){
            return root.val;
        }

        return deepestLeavesSumRec1(root.left, currH+1, h) + deepestLeavesSumRec1(root.right, currH+1, h);
    }


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


    public static TreeNode strArrayToTree(String input){
        String[] split = input.split(",");
        int n = split.length;
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i=1;
        while (i<split.length && !queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(!split[i].equals("null")) {
                poll.left = new TreeNode(Integer.parseInt(split[i]));
                queue.offer(poll.left);
            }

            if(i+1<n && !split[i+1].equals("null")) {
                poll.right = new TreeNode(Integer.parseInt(split[i+1]));;
                queue.offer(poll.right);
            }

            i+=2;
        }

        return root;
    }


}
