package medium;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        Node one = new Node(1,new ArrayList<>());
        Node two = new Node(2,new ArrayList<>());
        Node three = new Node(3,new ArrayList<>());
        Node four = new Node(4,new ArrayList<>());

        one.neighbors.add(two);
        one.neighbors.add(four);

        two.neighbors.add(one);
        two.neighbors.add(three);

        three.neighbors.add(two);
        three.neighbors.add(four);

        four.neighbors.add(one);
        four.neighbors.add(three);


        Node g1 = new Solution().cloneGraph(one);
        Node g2 = new Solution1().cloneGraph(one);
        System.out.println(" printGraph(g1);");
        printGraph(g1);
        System.out.println(" printGraph(g2);");
        printGraph(g2);

        System.out.println("printGraphNodeHash(g1);");
        printGraphNodeHash(g1);
        System.out.println("printGraphNodeHash(g2);");
        printGraphNodeHash(g2);

    }

    private static class Solution1 {
        private HashMap <Node, Node> visited = new HashMap <> ();
        public Node cloneGraph(Node node) {
            if (node == null) {
                return node;
            }

            // If the node was already visited before.
            // Return the clone from the visited dictionary.
            if (visited.containsKey(node)) {
                return visited.get(node);
            }

            // Create a clone for the given node.
            // Note that we don't have cloned neighbors as of now, hence [].
            Node cloneNode = new Node(node.val, new ArrayList());
            // The key is original node and value being the clone node.
            visited.put(node, cloneNode);

            // Iterate through the neighbors to generate their clones
            // and prepare a list of cloned neighbors to be added to the cloned node.
            for (Node neighbor: node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }
            return cloneNode;
        }
    }

    private static class Solution {
        public Node cloneGraph(Node node) {
            if (node==null) return node;

            Node clone = new Node(node.val, new ArrayList<>());
            Map<Integer, Node> visited = new HashMap<>();
            for (Node original : node.neighbors) {
                if(visited.containsKey(original.val)){
                    clone.neighbors.add(visited.get(original.val));
                    continue;
                }

                cloneGraphDFS(original, clone, visited);
            }

            return clone;
        }

        public void cloneGraphDFS(Node original, Node cloneParent, Map<Integer, Node> visited) {
            Node clone = new Node(original.val, new ArrayList<>());
            cloneParent.neighbors.add(clone);

            visited.put(original.val, clone);

            for (Node originalNeighbor : original.neighbors) {
                if(visited.containsKey(originalNeighbor.val)){
                    clone.neighbors.add(visited.get(originalNeighbor.val));
                    continue;
                }

                cloneGraphDFS(originalNeighbor, clone, visited);
            }
        }
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // input [[2,4],[1,3],[2,4],[1,3]]
    // output [[medium.CloneGraph$Node@3feba861,medium.CloneGraph$Node@5b480cf9][medium.CloneGraph$Node@6f496d9f,medium.CloneGraph$Node@723279cf][medium.CloneGraph$Node@3feba861,medium.CloneGraph$Node@5b480cf9][medium.CloneGraph$Node@6f496d9f,medium.CloneGraph$Node@723279cf]]
    // ref problem https://leetcode.com/problems/clone-graph
    static void printGraphNodeHash(Node graph){
        Stack<Node> stack = new Stack<>();
        stack.add(graph);

        Set<Integer> visited = new HashSet<>();

        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()){
            Node poll = stack.pop();
            if(visited.contains(poll.val)) continue;

            visited.add(poll.val);

            output.append("[");
            List<Node> neighbors = new ArrayList<>();
            for (Node neighbor : poll.neighbors) {
                if(!visited.contains(neighbor.val))neighbors.add(neighbor);
                output.append(neighbor);
                output.append(",");
            }
            Collections.reverse(neighbors);
            stack.addAll(neighbors);

            if(!output.isEmpty() && output.length()>1) output.delete(output.length()-1, output.length());
            output.append("]");
        }

        output.insert(0,"[");
        output.append("]");

        System.out.println(output.toString());
    }


    // input [[2,4],[1,3],[2,4],[1,3]]
    // output [[2,4][1,3][2,4][1,3]]
    // ref problem https://leetcode.com/problems/clone-graph

    static void printGraph(Node graph){
        Stack<Node> stack = new Stack<>();
        stack.add(graph);

        Set<Integer> visited = new HashSet<>();

        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()){
            Node poll = stack.pop();
            if(visited.contains(poll.val)) continue;

            visited.add(poll.val);

            output.append("[");
            List<Node> neighbors = new ArrayList<>();
            for (Node neighbor : poll.neighbors) {
                if(!visited.contains(neighbor.val))neighbors.add(neighbor);
                output.append(neighbor.val);
                output.append(",");
            }
            Collections.reverse(neighbors);
            stack.addAll(neighbors);

            if(!output.isEmpty() && output.length()>1) output.delete(output.length()-1, output.length());
            output.append("]");
        }

        output.insert(0,"[");
        output.append("]");

        System.out.println(output.toString());
    }

}
