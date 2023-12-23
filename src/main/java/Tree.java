import medium.AllElementsInTwoBinarySearchTrees;
import medium.DeepestLeavesSum;

import java.util.*;

public class Tree {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
//
//        List<Integer> output =  preorderTraversal(root);
//
//        System.out.println();
//        for (Integer val : output) {
//            System.out.print(val);
//            System.out.print(" ");
//        }

//          TreeNode root =
//                  new TreeNode(37,
//                          new TreeNode(-34, null, new TreeNode(-100)),
//                          new TreeNode(-48, new TreeNode(-100), new TreeNode(48)));
//          List<List<Integer>> rez = findLeaves(root);
//
//        for (List<Integer> integers : rez) {
//            for (Integer integer : integers) {
//                System.out.print(integer+" ");
//            }
//            System.out.println();
//        }
        TreeNode test = strArrayToTree("1,2,3,4,5,null,6,7,null,null,null,null,8");
        System.out.println();
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root.right != null || root.left != null){
            queue.offer(root);
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode curr = queue.poll();
                TreeNode parent = queue.poll();

                if(curr.left == null && curr.right == null) {
                    stack.add(curr);
                    if(parent.left!=null && parent.left.val == curr.val){
                        parent.left = null;
                    } else if(parent.right!=null) {
                        parent.right = null;
                    }

                    continue;
                }

                if(curr.left != null) {
                    queue.offer(curr.left);
                    queue.offer(curr);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                    queue.offer(curr);
                }
            }

            List<Integer> level = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                level.add(pop.val);
            }

            output.add(level);
        }
        output.add(new ArrayList<>(List.of(root.val)));

        return output;
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

    //    public static void main(String[] args)
//    {
//        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15,null,new TreeNode(18)));
//        inOrderSum(root,0,1);
//    }


    public static int inOrderSum(TreeNode root, int low, int high)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        int sum=0;
        while(curr!=null || !stack.isEmpty())
        {
            while (curr!=null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(curr.val>=low&&curr.val<=high)
            {
                sum+= curr.val;
            }

            if(curr.val>high)
            {
                break;
            }
            curr = curr.right;

            return sum;
        }

        return 0;
    }

    public static List<TreeNode> inOrderReverseItr(TreeNode root)
    {
        List<TreeNode> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr!=null & !stack.isEmpty())
        {
            while (curr!=null)
            {
                stack.push(curr);
                curr = curr.right;
            }
            curr=stack.pop();
            output.add(curr);
            curr=curr.left;
        }

        return output;
    }


    public static List<TreeNode> levelOrder(TreeNode root)
    {
        List<TreeNode> output = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            output.add(node);
            if(node.left != null)
            {
                queue.offer(node.left);
            }
            if(node.right != null)
            {
                queue.offer(node.right);
            }
        }

        return output;
    }

    public static TreeNode invertTree(TreeNode root) {
        return invertTreeRec(root);
    }

    public static TreeNode invertTreeRec(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = invertTreeRec(root.right);
        root.right = invertTreeRec(temp);

        return root;
    }

    public boolean postOrderEval(TreeNode root)
    {
        if(root == null)
        {
            return false;
        }
        if(root.val==0)
        {
            return true;
        }
        if(root.val==1)
        {
            return false;
        }

        boolean left = postOrderEval(root.left);
        boolean right = postOrderEval(root.right);

        return root.val == 2 ? left || right : left && right;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private static void preOrder(Node root, List<Integer> output) {
        if(root == null)
        {
            return;
        }

        output.add(root.val);

        if(root.children == null)
        {
            return;
        }

        for (Node child : root.children) {
            preOrder(child, output);
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            output.add(curr.val);
            if(curr.right!=null)
            {
                stack.add(curr.right);
            }

            if(curr.left!=null)
            {
                stack.add(curr.left);
            }
        }

        return output;
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
}
