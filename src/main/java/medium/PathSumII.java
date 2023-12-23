package medium;

import java.util.*;

public class PathSumII {
    public static void main(String[] args) {
        String input = "-2,null,-3";
        List<List<Integer>> output = new PathSumII().pathSum(strArrayToTree(input), -2);
        System.out.println();
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        if(root==null)return output;
        pathSumRec(root, targetSum, output, new Stack<>(), 0);
        return output;
    }

    private void pathSumRec(TreeNode root, int targetSum, List<List<Integer>> output, Stack<Integer> path, int sum) {
        if(root == null) return;

        path.add(root.val);
        pathSumRec(root.left, targetSum, output, path, sum+root.val);
        pathSumRec(root.right, targetSum, output, path, sum+root.val);

        if(root.left==null && root.right==null && sum+root.val==targetSum)
            output.add(new ArrayList<>(path));

        path.pop();
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
