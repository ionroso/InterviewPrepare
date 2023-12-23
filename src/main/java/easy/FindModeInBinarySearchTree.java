package easy;

import com.sun.security.auth.UnixNumericUserPrincipal;

import java.util.*;

public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        TreeNode twoLeaf =  new TreeNode(2);
        TreeNode twoLevelOne = new TreeNode(2, twoLeaf, null);
        TreeNode root = new TreeNode(1, null, twoLevelOne);

        int[] rez = new FindModeInBinarySearchTree().findMode(root);
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
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[]{};

        Map<Integer, Integer> nodeFreq = new HashMap<>();
        Map<Integer, Set<Integer>> freqToNodes = new HashMap<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        int max = -1;
        while (head != null || !stack.isEmpty()){
            while (head != null){
                stack.add(head);
                head = head.left;
            }

            head = stack.pop();

            int f = nodeFreq.getOrDefault(head.val,0);

            if(f != 0){
                Set<Integer> currFreqSet = freqToNodes.getOrDefault(f, new HashSet<>());
                currFreqSet.remove(head.val);
                freqToNodes.put(f, currFreqSet);
            }

            f++;

            Set<Integer> nextFreqSet = freqToNodes.getOrDefault(f, new HashSet<>());
            nextFreqSet.add(head.val);
            freqToNodes.put(f, nextFreqSet);

            nodeFreq.put(head.val, f);

            max = Math.max(max, f);

            head = head.right;
        }

        if(max == -1) {
          return new int[]{};
        }

        Set<Integer> currFreqSet = freqToNodes.get(max);
        int[] out = new int[currFreqSet.size()];
        int i = 0;
        for (int entry : currFreqSet) {
            out[i++] = entry;
        }

        return out;
    }
}
