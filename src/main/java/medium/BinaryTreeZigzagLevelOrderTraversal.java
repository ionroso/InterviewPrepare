package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        String input = "3,9,20,null,null,15,7";
        List<List<Integer>> output = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(strArrayToTree(input));
        System.out.println();
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();

        boolean leftToRight = true;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()){
            LinkedList<TreeNode> temp = new LinkedList<>();
            List<Integer> currOut = new ArrayList<>();
            if(leftToRight){
                while (!nodes.isEmpty()){
                    TreeNode n = nodes.removeFirst();
                    currOut.add(n.val);

                    if(n.left!=null)
                        temp.addLast(n.left);
                    if(n.right!=null)
                        temp.addLast(n.right);

                }
            } else {
                while (!nodes.isEmpty()){
                    TreeNode n = nodes.removeLast();
                    currOut.add(n.val);

                    if(n.left!=null)
                        temp.addLast(n.left);
                    if(n.right!=null)
                        temp.addLast(n.right);                }
            }
            nodes=temp;
            output.add(currOut);
            leftToRight=!leftToRight;
        }

        return output;
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
