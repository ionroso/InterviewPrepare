package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneNAryTree {

    public Node cloneTree(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        Queue<Node> cloneQueue = new LinkedList<>();
        Node clone = new Node();
        clone.val = root.val;
        cloneQueue.offer(clone);

        while (!queue.isEmpty()){
            Node poll = queue.poll();
            Node clonePoll = cloneQueue.poll();
            clonePoll.children = new ArrayList<>();
            for (Node child : poll.children) {
                Node cloneChild = new Node();
                cloneChild.val = child.val;
                clonePoll.children.add(cloneChild);
                cloneQueue.offer(cloneChild);
                queue.offer(child);

            }
        }

        return clone;
    }









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

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }


}
