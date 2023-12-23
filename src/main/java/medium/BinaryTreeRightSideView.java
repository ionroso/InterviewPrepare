package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    private class TreeNode {
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

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> output = new ArrayList<>();

        while (!queue.isEmpty()){
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.right != null)
                    temp.offer(node.right);
                if(node.left != null)
                    temp.offer(node.left);
            }
            queue=temp;
            if(!queue.isEmpty())
                output.add(queue.peek().val);
        }

        return output;
    }
}
