package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DiameterOfNAryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<>();
        Node two = new Node(2);
        Node three = new Node(3);
        two.children.add(new Node(4));
        root.children.add(two);
        root.children.add(three);

        System.out.println(new DiameterOfNAryTree().diameter(root));
    }
    static class Node {
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

    static class Diameter {
        int d = 1;
    }

    public int diameter(Node root) {
        Diameter d = new Diameter();
        diameterRec(root, d);
        return d.d;
    }

    public int diameterRec(Node root, Diameter diameter) {

        if(root.children.size() == 0) {
            return 1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(2, (o1, o2) -> o2-o1);

        for(Node child : root.children){
            int temp = diameterRec(child, diameter);
            maxHeap.offer(temp);
        }

        int poll1 = maxHeap.poll();
        int poll2 = !maxHeap.isEmpty() ? maxHeap.poll() : 0;

        int d = poll1 + poll2;
        diameter.d = Math.max(diameter.d, d);

        return poll1+1;

    }
}
