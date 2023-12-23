package medium;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = strArrayToTree("0,1,null,null,2,null,3,null,4");
        List<Integer> rez = new AllNodesDistanceKInBinaryTree().distanceK(root, new TreeNode(3), 0);
        System.out.println();
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

    private static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        bfs(root, g);
        return bfs(g, target, k);
    }

    private List<Integer> bfs(Map<Integer, List<Integer>> g, TreeNode target, int k) {
            List<Integer> output = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(target.val);


            int level = 0;
            while (!queue.isEmpty()){
                if(level == k){
                    break;
                }

                int i = queue.size();
                while (i>0){
                    int node = queue.poll();
                    if(!visited.contains(node)) {
                        queue.addAll(g.get(node));
                        visited.add(node);
                    }
                    i--;
                }

                level++;
            }

            while (!queue.isEmpty()){
                int node = queue.poll();
                if(!visited.contains(node)){
                    output.add(node);
                    visited.add(node);
                }
            }


            return output;
    }

    private void bfs(TreeNode root, Map<Integer, List<Integer>> graph) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        graph.put(root.val, new ArrayList<>());

        while (!queue.isEmpty()){
            int i = queue.size();
            while (i>0){
                TreeNode node = queue.poll();
                if(node.left!=null) {
                    addToGraph(graph, node.val, node.left.val);
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    addToGraph(graph, node.val, node.right.val);
                    queue.offer(node.right);
                }
                i--;
            }
        }
    }

    private void addToGraph(Map<Integer, List<Integer>> graph, int from, int to) {
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
    }
}
