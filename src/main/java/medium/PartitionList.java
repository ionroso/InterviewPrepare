package medium;

import java.util.List;

public class PartitionList {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {

        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

        public void test() {
//            ListNode root  = new ListNode(1);
//            root.next = new ListNode(4);
//            root.next.next = new ListNode(3);
//            root.next.next.next = new ListNode(2);
//            root.next.next.next.next = new ListNode(5);
//            root.next.next.next.next.next = new ListNode(2);
//
//
//            System.out.println(new Solution().partition(root, 3));


            ListNode root  = new ListNode(1);
            System.out.println(new Solution().partition(root, 0));
        }

        class Solution {
            public ListNode partition(ListNode head, int x) {
                ListNode smaller = new ListNode(-1);
                ListNode headS = smaller;
                ListNode bigger = new ListNode(-1);
                ListNode headB = bigger;

                while (head != null){
                    ListNode temp = new ListNode(head.val);
                    if(head.val<x){
                        smaller.next=temp;
                        smaller = smaller.next;
                    } else {
                        bigger.next=temp;
                        bigger = bigger.next;
                    }

                    head = head.next;
                }

                headS = headS.next;
                headB = headB.next;

                if(headS == null){
                    return headB;
                }

                smaller.next = headB;

                return headS;
            }
        }
    }
}
