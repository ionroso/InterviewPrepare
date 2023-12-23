package medium;

import java.util.*;

public class FindRootOfNAryTree {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public Node findRoot(List<Node> tree) {
        Set<Integer> hasParent = new HashSet<>();
        for (Node node : tree) {
            for (Node child : node.children) {
                dfs(child, hasParent);
            }
        }

        Node output = null;
        for (Node node : tree) {
            if(!hasParent.contains(node.val)){
                output = node;
                break;
            }
        }

        return output;
    }

    private void dfs(Node parent,  Set<Integer> hasParent) {
        hasParent.add(parent.val);
        for (Node child : parent.children) {
            dfs(child,hasParent);
        }
    }
}
