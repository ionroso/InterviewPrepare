package medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Node root = strArrayToTree("1,2,3,4,5,6,7");
        Node rez = new PopulatingNextRightPointersInEachNode().connect(root);
        System.out.println();
    }
    public static Node strArrayToTree(String input){
        String[] split = input.split(",");
        int n = split.length;
        Node root = new Node(Integer.parseInt(split[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i=1;
        while (i<split.length && !queue.isEmpty()){
            Node poll = queue.poll();
            if(!split[i].equals("null")) {
                poll.left = new Node(Integer.parseInt(split[i]));
                queue.offer(poll.left);
            }

            if(i+1<n && !split[i+1].equals("null")) {
                poll.right = new Node(Integer.parseInt(split[i+1]));;
                queue.offer(poll.right);
            }

            i+=2;
        }

        return root;
    }

   static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        root.next=null;
        while (!queue.isEmpty()){
            Queue<Node> temp = new LinkedList<>();
            while (!queue.isEmpty()){
                Node node = queue.poll();
                if(node.left!=null) {
                    temp.offer(node.left);
                }
                if(node.right!=null) {
                    temp.offer(node.right);
                }
            }

            if(!temp.isEmpty()) {
                int size = temp.size() - 1;
                Node prev = temp.poll();
                while (size > 0) {
                    Node curr = temp.poll();
                    prev.next = curr;
                    temp.offer(prev);
                    prev = curr;
                    size--;
                }
                prev.next = null;
                temp.offer(prev);
                queue=temp;
            }

        }

        return root;
    }
}
