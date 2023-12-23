package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        String input = "1,2,3,null,6,7,8";
        System.out.println(new CheckCompletenessOfABinaryTree().isCompleteTree(strArrayToTree(input)));
    }
    public boolean isCompleteTree(TreeNode root) {
        int h = getMaxHigth(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        Queue<TreeNode> temp = new LinkedList<>();
        List<TreeNode> last = new LinkedList<>();

        int level = 1;
        while (!queue.isEmpty()){
            if(level!=h && queue.size() != Math.pow(2, level-1)) return false;
            temp = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(level < h-1){
                    if (node.left != null) temp.offer(node.left);
                    if (node.right != null) temp.offer(node.right);
                } else {
                    last.add(node.left);
                    last.add(node.right);
                }
            }
            queue=temp;
            level++;
        }

        boolean foundTheLastNode = false;
        for (int i = 0; i < last.size(); i++) {
            TreeNode curr = last.get(i);
            if(foundTheLastNode && curr!=null)
                return false;
            if(curr==null)
                foundTheLastNode = true;
        }

        return true;
    }

    private int getMaxHigth(TreeNode root) {
       if(root==null) return 0;
       return Math.max(getMaxHigth(root.left), getMaxHigth(root.right)) +1;
    }


   static private class TreeNode {
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
