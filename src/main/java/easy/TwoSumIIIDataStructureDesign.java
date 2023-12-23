package easy;

import java.util.*;

public class TwoSumIIIDataStructureDesign {

    private static class TreeNode {
        int val;
        int count;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.count = 1;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            super();
            this.left = left;
            this.right = right;
        }

        void increaseCount(){
            count++;
        }

        int getCount(){
            return count;
        }
    }

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        test.add(3);
        test.add(1);
        test.add(2);
        System.out.println(test.findWithInOrder(test.root, 3));
    }
    private static
    class TwoSum {
        TreeNode root;
        Map<Integer, Integer> freq;

        public TwoSum() {
            freq = new HashMap<>();
        }

        public void add(int number) {
            if(root==null){
                root = new TreeNode(number);
                return;
            }

            insertInBST(root, number);
        }

        private TreeNode insertInBST(TreeNode root, int number) {
            if(root==null) { return new TreeNode(number); }

            if(number == root.val){
                root.increaseCount();
            } else if(number < root.val)
            {
                root.left = insertInBST(root.left, number);
            } else {
                root.right =  insertInBST(root.right, number);
            }

            return root;
        }

        private boolean findWithInOrder(TreeNode root, int original){

            int half = original/2+1;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;

            while (curr!= null || !stack.isEmpty()){
                while (curr!= null)
                {
                    stack.push(curr);
                    curr=curr.left;
                }

                curr = stack.pop();

                if(curr.val>half){
                    break;
                }

                TreeNode tempTN = findBST(root, original-curr.val);
                if(tempTN != null){
                    if(curr.val == original-curr.val && tempTN.count < 2) return false;

                    return true;
                }

                curr = curr.right;
            }

            return false;
        }

        private TreeNode findBST(TreeNode root, int val) {
            if(root==null) return root;

            if(root.val==val) return root;

           return root.val > val ?  findBST(root.left, val) : findBST(root.right, val);
        }

        public boolean find(int value) {

            return findWithInOrder(root, value);
        }
    }
}
