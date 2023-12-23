package easy;

public class LinkedListCycle {
    
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode s = head, f = head.next;

        while (f.next != null && f.next.next != null && s != f){
             s = s.next;
             f = f.next.next;
        }

        return s == f;
    }
}
