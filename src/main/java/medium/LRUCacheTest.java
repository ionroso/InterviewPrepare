package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCacheTest {

    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 0); // cache is {1=1}
//        lRUCache.put(2, 2); // cache is {1=1, 2=2}
//        lRUCache.get(1);    // return 1
//        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//        lRUCache.get(2);    // returns -1 (not found)
//        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//        lRUCache.get(1);    // return -1 (not found)
//        lRUCache.get(3);    // return 3
//        lRUCache.get(4);    // return 4


        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1); // cache is {1=1, 2=2}
        lRUCache.get(2);    // return 1
        lRUCache.put(3, 2); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.get(3);    // return 3


    }


    static
    class LRUCache {

        private class ListNode {

            int id, val;

            ListNode prev, next;
            public ListNode(int id, int val) {
                this.id = id;
                this.val = val;
            }


        }
        private final int capacity;
        private int size;
        private ListNode head, tail;

        Map<Integer, ListNode> keyToTreeNode;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.keyToTreeNode = new HashMap<>();
        }

        public int get(int key) {
            if(keyToTreeNode.isEmpty() || !keyToTreeNode.containsKey(key)){
                return -1;
            }
            ListNode temp = keyToTreeNode.get(key);
            moveToTail(temp);

            return temp.val;
        }

        private void moveToTail(ListNode temp) {
            if(temp == tail) {
                return;
            }

            if(temp == head){
                head = head.next;
                head.prev = null;
                temp.next = null;
                temp.prev = null;
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }

            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }

        public void put(int key, int value) {
            if(isEmpty()){
                ListNode newNode = new ListNode(key, value);
                head = tail = newNode;
                keyToTreeNode.put(key, newNode);
                increaseSize();
                return;
            }

            if(!keyToTreeNode.containsKey(key)) {
                ListNode newNode = new ListNode(key, value);
                insertAtTail(newNode);
                keyToTreeNode.put(key, newNode);
            } else {
                ListNode toUpdate = keyToTreeNode.get(key);
                toUpdate.val = value;
                moveToTail(toUpdate);
            }
        }

        private void insertAtTail(ListNode newNode) {
            if(isFull()){
                evict();
            }

            if(isEmpty()){
                head = tail = newNode;
                keyToTreeNode.put(newNode.id, newNode);
                increaseSize();
                return;
            }

            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            increaseSize();
        }

        private void evict() {
            if(size == 1){
                head = tail = null;
                keyToTreeNode.clear();
                decreaseSize();
                return;
            }

            ListNode toRem = head;
            head = head.next;
            toRem.next = null;
            head.prev = null;
            keyToTreeNode.remove(toRem.id);
            decreaseSize();
        }

        private boolean isFull(){
            return capacity == size;
        }

        private boolean isEmpty(){
            return size == 0;
        }

        private void increaseSize(){
            size++;
        }

        private void decreaseSize(){
            size--;
        }
    }
}
