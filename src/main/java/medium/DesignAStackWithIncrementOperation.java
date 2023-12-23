package medium;

public class DesignAStackWithIncrementOperation {

    public static void main(String[] args) {
        CustomStack stk = new CustomStack(3); // Stack is Empty []
        stk.push(1);                          // stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        stk.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        stk.push(3);                          // stack becomes [1, 2, 3]
        stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
        stk.increment(5, 100);                // stack becomes [101, 102, 103]
        stk.increment(2, 100);                // stack becomes [201, 202, 103]
        stk.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        stk.pop();                            // return 202 --> Return top of the stack 202, stack becomes [201]
        stk.pop();                            // return 201 --> Return top of the stack 201, stack becomes []
        stk.pop();                            // return -1 --> Stack is empty return -1.
    }

    static
    class CustomStack {
        private class Node {
            Node next;
            Node prev;
            int val;

            public Node(int val) {
                this.val = val;
            }
        }

        private final int maxSize;
        private int currSize;
        private Node tail;
        private Node head;

        public CustomStack(int maxSize) {

            this.maxSize = maxSize;
        }

        public void push(int x) {

            if(currSize == maxSize) {
                return;
            }

            Node newNode = new Node(x);

            if(head == null) {
                head = newNode;
                tail = newNode;
                currSize=1;
                return;
            }

            head.next = newNode;
            newNode.prev = head;
            head = newNode;
            currSize++;
        }

        public int pop() {
            if(currSize == 0 ) {
                return -1;
            }

            Node temp = head;
            head = head.prev;

            temp.prev = null;

            if(head!=null){
                head.next = null;
            }
            currSize--;


            return temp.val;

        }

        public void increment(int k, int val) {
            Node temp = tail;
            int i=0;
            while (temp!=null && i < k){
                temp.val+=val;
                temp = temp.next;
            }
        }
    }
}
