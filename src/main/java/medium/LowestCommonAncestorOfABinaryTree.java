package medium;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode rez = new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, new TreeNode(1), new TreeNode(2));
        System.out.println(rez.val);
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
    
    static class Found {
        boolean val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pPath = new LinkedList<>();
        LinkedList<TreeNode> qPath = new LinkedList<>();


        lcaRec(root,p, pPath, new Found(), q, qPath, new Found());

        TreeNode prev = null;
        while(!pPath.isEmpty() && !qPath.isEmpty() && Objects.equals(pPath.getFirst(), qPath.getFirst())){
            prev = pPath.getFirst();
            pPath.removeFirst();
            qPath.removeFirst();
        }

        return prev;
    }

    public void lcaRec(
            TreeNode root,
            TreeNode p,
            LinkedList<TreeNode> pPath,
            Found pFound,
            TreeNode q,
            LinkedList<TreeNode> qPath,
            Found qFound) {

        if(pFound.val && qFound.val) return;

        if(root == null) return;

        if(!pFound.val) pPath.addLast(root);
        if(!qFound.val) qPath.addLast(root);

        if(p.val==root.val) pFound.val = true;
        if(q.val==root.val) qFound.val = true;

        lcaRec(root.left, p, pPath, pFound, q, qPath, qFound);
        lcaRec(root.right, p, pPath, pFound, q, qPath, qFound);

        if(!pFound.val) pPath.removeLast();
        if(!qFound.val) qPath.removeLast();
    }
}
