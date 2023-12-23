package easy;

public class RemoveLinkedListElements {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }
    public ListNode removeElements(ListNode head, int val) {

        if(head == null || (head.next == null &&  head.val == val)) return null;

        ListNode pointer = head;
        while (pointer != null && pointer.val == val){
            ListNode temp = pointer.next;
            pointer.next = null;
            pointer = temp;
        }

        if(pointer == null)
            return null;

        ListNode newHead = pointer;
        ListNode prev = pointer;
        ListNode curr = pointer.next;

        while (curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return newHead;
    }
}
