package easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        System.out.println(new LeafSimilarTrees().leafSimilar(new TreeNode(1, null, null), new TreeNode(2, null, null)));
    }
 static private class TreeNode {
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return false;


        List<Integer> rootOneLeafs = new ArrayList<>();
        List<Integer> rootTwoLeafs = new ArrayList<>();
        leafRec(root1, rootOneLeafs);
        leafRec(root2, rootTwoLeafs);
        if(rootOneLeafs.size() != rootTwoLeafs.size()) return false;

        Iterator<Integer> iter1 = rootOneLeafs.iterator();
        Iterator<Integer> iter2 = rootTwoLeafs.iterator();
        while(iter1.hasNext()){
            if(iter1.next() != iter2.next()) break;
        }

        return !(iter1.hasNext() && iter2.hasNext());
    }

    public void leafRec(TreeNode root, List<Integer> leafs) {
        if(root == null) return;

        if(root.left == null && root.right == null){
            leafs.add(root.val);
            return;
        }


        leafRec(root.left, leafs);
        leafRec(root.right, leafs);
    }
}
