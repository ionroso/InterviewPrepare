package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        two.left = four;
        two.right = five;

        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        three.left = six;
        three.right = seven;

        root.left = two;
        root.right = three;

        int[] to_delete = new int[]{3,5};

        delNodes(root, to_delete);
    }

    static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> output = new ArrayList<>();
        Set<Integer> toDel = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            toDel.add(to_delete[i]);
        }
        postOrder(root, output, toDel);

        return output;
    }

   static void postOrder(TreeNode root, List<TreeNode> output, Set<Integer> toDel) {
        if (root == null) return;
        postOrder(root.left, output, toDel);
        postOrder(root.right, output, toDel);

        if(toDel.contains(root.val)){
            if (root.left != null) {
                output.add(root);
            }

            if (root.right != null) {
                output.add(root);
            }
        }
       if (root.left != null && toDel.contains(root.val)) {
           root.left = null;
       }

       if (root.right != null && output.add(root)) {
           root.right = null;
       }

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
}
