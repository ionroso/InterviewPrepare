package medium;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class FindDistanceInABinaryTree {
    static class Found {
        boolean val;
    }
    private static class TreeNode {
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
        TreeNode test = strArrayToTree("430,5306,null,5137,null,12970,null,null,7286,19989,null,null,6609,108,null,8433,null,1750,null,10835,null,null,3798,12795");
        System.out.println(new FindDistanceInABinaryTree().findDistance(test,5306,12795));
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

    public int findDistance(TreeNode root, int p, int q) {
        if(p==q) return 0;

        Found pFound = new Found();
        Found qFound = new Found();

        LinkedList<Integer> pPath = new LinkedList<>();
        LinkedList<Integer> qPath = new LinkedList<>();

        findDistanceRec(root, p, pFound, pPath, q, qFound, qPath);

        while(!pPath.isEmpty() && !qPath.isEmpty() && Objects.equals(pPath.getFirst(), qPath.getFirst())){
            pPath.removeFirst();
            qPath.removeFirst();
        }

        return pPath.size() + qPath.size();
    }

    public void findDistanceRec(TreeNode root, int p, Found pFound, LinkedList<Integer> pPath, int q, Found qFound, LinkedList<Integer> qPath) {
        if(pFound.val && qFound.val) return;

        if(root == null) return;

        if(!pFound.val) pPath.addLast(root.val);
        if(!qFound.val) qPath.addLast(root.val);

        if(p==root.val) pFound.val = true;
        if(q==root.val) qFound.val = true;

        findDistanceRec(root.left, p, pFound, pPath, q, qFound, qPath);
        findDistanceRec(root.right, p, pFound, pPath, q, qFound, qPath);

        if(!pFound.val) pPath.removeLast();
        if(!qFound.val) qPath.removeLast();
    }
}
