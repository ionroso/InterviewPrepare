package medium;

import java.util.List;

public class DesignCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(5);  // return True
        myCircularDeque.getFront();      // return 2
        myCircularDeque.isEmpty();      // return 2
        myCircularDeque.deleteFront();      // return 2
        myCircularDeque.insertLast(3);      // return 2
        myCircularDeque.getRear();      // return 2
        myCircularDeque.insertLast(7);      // return 2
        myCircularDeque.insertFront(7);      // return 2
        myCircularDeque.deleteLast();      // return 2
        myCircularDeque.insertLast(4);      // return 2
        myCircularDeque.isEmpty();      // return 2
    }

    static
    class MyCircularDeque {

        class ListNode {
            ListNode next;
            ListNode prev;

            int val;

            public ListNode(int val) {
                this.val = val;
            }
        }

        ListNode rear, front;
        int capacity;
        int currSize;

        public MyCircularDeque(int k) {
            this.capacity = k;
        }

        public boolean insertFront(int value) {
            if(isFull()) {
                return false;
            }

            ListNode newNode = new ListNode(value);
            if(rear == null && front == null){
                rear = front = newNode;
            } else {
                front.next = newNode;
                newNode.prev = front;
                front = newNode;
            }

            currSize++;

            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()) {
                return false;
            }

            ListNode newNode = new ListNode(value);
            if(rear == null && front == null){
                rear = front = newNode;
            } else {
                rear.prev = newNode;
                newNode.next = rear;
                rear = newNode;
            }

            currSize++;

            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()) {
                return false;
            }

            if(currSize == 1){
                rear = front = null;
            } else if(currSize == 2){
                ListNode toDel = front;
                front = rear;
                front.next = null;
                toDel.prev = null;
            } else  {
                ListNode toDel = front;
                front = toDel.prev;
                front.next = null;
                toDel.prev = null;
            }

            currSize--;

            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()) {
                return false;
            }

            if(currSize == 1){
                rear = front = null;
            } else if(currSize == 2){
                ListNode toDel = rear;
                rear = front;
                rear.prev = null;
                toDel.next = null;
            } else {
                ListNode toDel = rear;
                rear = toDel.next;
                toDel.next = null;
            }

            currSize--;

            return true;
        }

        public int getFront() {
            if(currSize==0) {
                return -1;
            }

            return front.val;
        }

        public int getRear() {
            if(currSize==0) {
                return -1;
            }

            return rear.val;
        }

        public boolean isEmpty() {
            return currSize == 0;
        }

        public boolean isFull() {
            return currSize == capacity;
        }
    }
}
