package easy;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class TwoSumIVInputBST {
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

    public static void main(String[] args) {

    }

          public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            set.add(curr.val);

            if(curr.left != null) {
                queue.offer(curr.left);
            }
            if(curr.right != null) {
                queue.offer(curr.right);
            }
        }

        for (Integer num : set) {
            if(k-num == num) {
                continue;
            }

            if(set.contains(k-num)) {
                return true;
            }
        }

        return false;
    }
}
