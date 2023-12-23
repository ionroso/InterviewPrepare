package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2, new Node(1), new Node(3));
        System.out.println(new ConvertBinarySearchTreeToSortedDoublyLinkedList().treeToDoublyList(root));
    }

    public Node treeToDoublyList(Node root) {
        Stack<Node> stack = new Stack<>();
        Node trav = root;

        Node prev = null;
        Node head = null;
        Node curr = null;

        while (trav != null || !stack.isEmpty()){
            while (trav!=null){
                stack.add(trav);
                trav=trav.left;
            }

            Node poll = stack.pop();

            curr = new Node(poll.val);
            if(prev!=null){
                curr.left = prev;
                prev.right = curr;
            }

            if(head == null){
                head = curr;
            }

            prev=curr;
            trav = poll.right;
        }

        prev.right=head;
        head.left=curr;
        return head;
    }
}
