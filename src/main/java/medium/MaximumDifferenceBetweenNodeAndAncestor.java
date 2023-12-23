package medium;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        MaxVal max = new MaxVal();
        PriorityQueue<TreeNode> pqMin = new PriorityQueue<>((t1, t2) -> t1.val- t2.val);
        PriorityQueue<TreeNode> pqMax = new PriorityQueue<>((t1, t2) -> t2.val- t1.val);
        maxAncestorDiffRec(root, pqMin, pqMax, max);
        return max.val;
    }

    private void maxAncestorDiffRec(TreeNode root, PriorityQueue<TreeNode> pqMin, PriorityQueue<TreeNode> pqMax, MaxVal max) {
        if(root == null) return;


        if(pqMin.size() >= 1){
            max.val = Math.max(max.val, Math.abs(pqMin.peek().val - root.val));
        }

        if(pqMax.size() >= 1){
            max.val = Math.max(max.val, Math.abs(pqMax.peek().val - root.val));
        }

        pqMin.offer(root);
        pqMax.offer(root);

        maxAncestorDiffRec(root.left, pqMin, pqMax, max);
        maxAncestorDiffRec(root.right, pqMin, pqMax, max);

        pqMin.remove(root);
        pqMax.remove(root);
    }

    class MaxVal {
        Integer val=-1;
    }

    public static void main(String[] args) {
        String input = "8,3,10,1,6,null,14,null,null,4,7,13";
        System.out.println(new MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(strArrayToTree(input)));
    }
    private static class TreeNode {
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

    static TreeNode strArrayToTree(String input){
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
