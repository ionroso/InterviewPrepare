package medium;

import java.util.*;

public class AllElementsInTwoBinarySearchTrees {
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

    public static void main(String[] args) {
        TreeNode test1 = strArrayToTree("2,1,4");
        TreeNode test2 = strArrayToTree("1,0,3");

        List<Integer> out = new AllElementsInTwoBinarySearchTrees().getAllElements(test1, test2);
        System.out.println();

    }

    public void inOrder(TreeNode root, PriorityQueue<Integer> pq){
        if(root == null) return;

        inOrder(root.left, pq);
        pq.add(root.val);
        inOrder(root.right, pq);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        inOrder(root1, pq);
        inOrder(root2, pq);

        List<Integer> result = new ArrayList<>(pq.size());
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }

    public static TreeNode strArrayToTree(String input){
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


    public List<Integer> getAllElementsItr1(TreeNode root1, TreeNode root2) {

        List<Integer> output = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        TreeNode curr1 = root1;

        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode curr2 = root2;

        boolean next1 = true, next2 = true;

        while ((curr1 != null || !stack1.isEmpty()) || (curr2 != null || !stack2.isEmpty())) {
            if (next1) {
                while (curr1 != null) {
                    stack1.add(curr1);
                    curr1 = curr1.left;
                }
                next1 = false;
            }

            if (next2) {
                while (curr2 != null) {
                    stack2.add(curr2);
                    curr2 = curr2.left;
                }
                next2 = false;
            }

            if(stack1.isEmpty()) break;
            if(stack2.isEmpty()) break;

            TreeNode pop1 = stack1.peek();
            TreeNode pop2 = stack2.peek();

            if (pop1.val < pop2.val) {
                output.add(pop1.val);
                stack1.pop();
                next1 = true;
            } else {
                output.add(pop2.val);
                stack2.pop();
                next2 = true;
            }


            if (next1) {
                curr1 = pop1.right;
            }

            if (next2) {
                curr2 = pop2.right;
            }
        }


        while (curr1 != null || !stack1.isEmpty()) {
            while (curr1 != null) {
                stack1.add(curr1);
                curr1 = curr1.left;
            }

            TreeNode pop1 = stack1.pop();
            output.add(pop1.val);
            curr1 = pop1.right;
        }


        while (curr2 != null || !stack2.isEmpty()) {
            while (curr2 != null) {
                stack2.add(curr2);
                curr2 = curr2.left;
            }

            TreeNode pop2 = stack2.pop();
            output.add(pop2.val);
            curr2 = pop2.right;
        }

        return output;
    }
}
