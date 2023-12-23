package medium;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {

    class Solution {
        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode> output = new ArrayList<>();
            allPossibleFBTRec(new TreeNode(0), output, n, 1);
            return output;

        }

        public void allPossibleFBTRec(TreeNode root, List<TreeNode> output, int n, int size) {

            root.left=new TreeNode(0);
            root.right=new TreeNode(0);
            size+=2;

            if(size==n) {
                output.add(clone(root));
                return;
            }

            allPossibleFBTRec(root.left, output, n, size);
            root.left=new TreeNode(0);
            allPossibleFBTRec(root.right, output, n, size);
            root.right=new TreeNode(0);
        }

        public TreeNode clone(TreeNode root) {
            if(root == null) return null;
            TreeNode clone = new TreeNode(0);
            clone.left = root.left!=null ? clone(root.left) : null;
            clone.right = root.right!=null ? clone(root.right) : null;

            return clone;
        }

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
}
