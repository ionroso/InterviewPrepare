package medium;

public class FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        Node one = new Node();
        one.val = 1;
        Node two = new Node();
        two.val=2;
        Node three = new Node();
        three.val=3;

        one.child=two;
        two.child=three;

        Node rez = new FlattenAMultilevelDoublyLinkedList().flatten(one);
        System.out.println();

    }
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private void dfs(Node root) {
        Node head = root;
        while (head!=null){
            if(head.child!=null){
              Node last = dfsGetLast(head.child);
              Node tmp = head.next;

              last.next=tmp;
              tmp.prev=last;

              head.next=head.child;
              head.child.prev = head;
              head.child = null;
            }

            head = head.next;
        }
    }

    private Node dfsGetLast(Node head) {
        Node prev = head;
        while (head!=null){
            prev = head;
            head = head.next;
        }

        return prev;
    }
}
