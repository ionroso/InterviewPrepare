package medium;

import java.util.HashMap;
import java.util.Map;

public class DesignMostRecentlyUsedQueue {

    public static void main(String[] args) {
        DesignMostRecentlyUsedQueue.MRUQueue mruq = new MRUQueue(6);
        System.out.println(mruq.fetch(1));
        System.out.println(mruq.fetch(5));
        System.out.println(mruq.fetch(5));
    }

    static
    class Node {
        Node prev;
        Node next;

        int val;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next) {
            super();
            this.prev = prev;
            this.next = next;
        }
    }

    static
    class MRUQueue {
        Node tail;
        Node head;

        int n;

        public MRUQueue(int n) {
            this.n = n;
            Node prev = null;
            for (int i = 1; i <= n; i++) {
                Node node = new Node(i);
                if(i==1){
                    tail = node;
                    prev = tail;
                    continue;
                }
                prev.next = node;
                node.prev = prev;
                prev = node;
            }

            head = prev;
        }

        public int fetch(int k) {
            if(k==n) return head.val;

            Node temp = findNode(k);
            disconnectNode(temp);
            makeHead(temp);

            return temp.val;
        }

        private void makeHead(Node temp) {
            if (temp == null){
                return;
            }

            head.next = temp;
            temp.prev = head;

            head = temp;
        }

        private void disconnectNode(Node temp) {
            if (temp == null){
                return;
            }

            Node prev = temp.prev;
            Node next = temp.next;

            if(prev!=null){
                prev.next = next;
            } else {
                tail = next;
            }

            if(next!=null){
                next.prev = prev;
            }

            temp.prev = null;
            temp.next = null;
        }

        private Node findNode(int k) {
            Node temp = tail;
            int i=1;
            while (i < k){
                temp = temp.next;
                i++;
            }
            return temp;
        }
    }
}
