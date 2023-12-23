package medium;

import utility.IParser;
import utility.LeetcodeArgsParser;
import utility.LeetcodeInputIterator;
import utility.LeetcodeMethodsCallStackInputParser;

import java.util.Iterator;

public class DesignLinkedList {
    public static void main(String[] args) {
        IParser p = new LeetcodeMethodsCallStackInputParser(",");
        IParser p1 = new LeetcodeArgsParser();

        LeetcodeInputIterator method = new LeetcodeInputIterator(p, "[\"MyLinkedList\",\"addAtHead\",\"addAtTail\",\"addAtIndex\",\"get\",\"deleteAtIndex\",\"get\",\"get\",\"deleteAtIndex\",\"deleteAtIndex\",\"get\",\"deleteAtIndex\",\"get\"]");
        LeetcodeInputIterator input = new LeetcodeInputIterator(p1, "[[],[1],[3],[1,2],[1],[1],[1],[3],[3],[0],[0],[0],[0]]");

        Iterator<String> methodIterator = method;
        Iterator<String> inputIterator = input;


        MyLinkedList myLinkedList=null;

        int y = -1;
        while (methodIterator.hasNext()) {
            y++;

            String methodName = methodIterator.next();
            String val = inputIterator.next();
            System.out.println();
            switch (methodName) {
                case "MyLinkedList": {
                    System.out.print(y+":");
                    myLinkedList = new MyLinkedList();
                    break;
                }
                case "addAtHead": {
                    System.out.print(y+":");
                    myLinkedList.addAtHead(Integer.valueOf(val));
                    break;
                }
                case "addAtTail": {
                    System.out.print(y+":");
                    myLinkedList.addAtTail(Integer.valueOf(val));
                    break;
                }
                case "get": {
                    System.out.print(y+":");
                    System.out.println(myLinkedList.get(Integer.valueOf(val)));
                    break;
                }
                case "addAtIndex": {
                    System.out.print(y+":");
                    String[] vals = val.split(",");
                    myLinkedList.addAtIndex(Integer.valueOf(vals[0]),Integer.valueOf(vals[1]));
                    break;
                }
                case "deleteAtIndex": {
                    System.out.print(y+":");
                    myLinkedList.deleteAtIndex(Integer.valueOf(val));
                    break;
                }
            }
        }
    }

    static
    class MyLinkedList {
        private class Node {
            Node next;
            Node prev;

            int val;

            public Node(int val) {
                this.val = val;
            }
        }

        int size;

        private Node tail, head;

        public MyLinkedList() {

        }

        public int get(int index) {
            if(index>=size){
                return -1;
            }

            int i=0;
            Node curr = head;
            while (curr != null && i != index){
                curr = curr.next;
                i++;
            }

            return curr.val;
        }

        public void addAtTail(int val) {
            Node newNode = new Node(val);
            increaseSize();
            if(tail == null){
                tail = head = newNode;
                return;
            }

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        public void addAtHead(int val) {
            Node newNode = new Node(val);
            increaseSize();
            if(head == null){
                tail = head = newNode;
                return;
            }

            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        private void increaseSize() {
            size++;
        }

        private void decreaseIndex() {
            size--;
        }

        public void addAtIndex(int index, int val) {
            if(index>size){
                return;
            }

            if(index==size){
                addAtTail(val);
                return;
            }

            if(index==0){
                addAtHead(val);
                return;
            }

            int i=0;
            Node curr = head;
            while (curr != null && i != index){
                curr = curr.next;
                i++;
            }

            Node newNode = new Node(val);
            Node prev = curr.prev;

            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = curr;
            curr.prev = newNode;

            increaseSize();
        }

        public void deleteAtIndex(int index) {
            if(index>=size){
                return;
            }

            if(index==0){
                if(size==1){
                    head = tail = null;
                    size = 0;
                    return;
                }

                Node toRem = head;
                head = head.next;
                toRem.next=null;
                head.prev = null;
                decreaseIndex();
                return;
            }

            if(index==size-1){
                Node toRem = tail;
                tail = tail.prev;
                toRem.prev = null;
                tail.next = null;
                decreaseIndex();
                return;
            }

            int i=0;
            Node curr = head;
            while (curr != null && i != index){
                curr = curr.next;
                i++;
            }

            Node prev = curr.prev;
            Node next = curr.next;

            curr.prev = null;
            curr.next = null;

            prev.next = next;
            next.prev = prev;

            decreaseIndex();
        }
    }
}
