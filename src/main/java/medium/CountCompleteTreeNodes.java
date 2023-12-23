package medium;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {


    public static void main(String[] args) {
        TreeNode root = strArrayToTree("1,2,3,4,5,6");
        System.out.println(new CountCompleteTreeNodes().countNodes(root));

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

    public int countNodes(TreeNode root) {
        int h = getHightMax(root)+1;
        int count = countNodesLastLevel(root, 1, h);

        return (int)Math.pow(2, h-1)-1 + count;
    }

    private int countNodesLastLevel(TreeNode root, int h, int maxH) {
        if(root==null) return 0;
        if(h==maxH) return 1;
        return countNodesLastLevel(root.left,h+1,maxH) + countNodesLastLevel(root.right, h+1,maxH);
    }

    private int getHightMax(TreeNode root) {
        if(root == null) return 0;

        return getHightMax(root.left) + 1;
    }
}
