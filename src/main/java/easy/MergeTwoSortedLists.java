package easy;

public class MergeTwoSortedLists {

private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        mergeTwoLists1(list1, list2);
    }

    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;

        if(list2 == null) return list1;

        ListNode curr, prev, newHead;
        curr = prev = newHead = list1;
        ListNode actual = list2;

        while (curr!=null && actual!=null)
        {
            ListNode temp = actual;
            ListNode next = actual.next;
            if(curr.val > actual.val){
                if(curr == newHead) {
                    temp.next = curr;
                    newHead = temp;
                    curr = prev = temp;
                } else {
                    temp.next = curr;
                    prev.next = temp;
                    curr = temp;
                }
                actual=next;
            } else if(curr.val == actual.val){
                if(curr == newHead) {
                    temp.next = newHead;
                    newHead = prev = temp;
                } else {
                    temp.next = curr;
                    prev.next = temp;
                    prev = temp;
                }
                actual=next;
            } else {
                prev = curr;
                curr=curr.next;
            }
        }

        if(actual!=null)
        {
            prev.next = actual;
        }

        return newHead;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;

        ListNode newHead = null, currHead = null, prevHead = null;

        int val;
        while (head1!=null && head2!=null){
            if(head1.val<=head2.val)
            {
                val =  head1.val;
                head1=head1.next;
            } else {
                val =  head2.val;
                head2=head2.next;
            }

            if(currHead == null)
            {
                currHead = newHead =  new ListNode(val);
            } else {
                prevHead = currHead;
                currHead.next = new ListNode(val);
                currHead = currHead.next;
            }
        }

        while (head1!=null){
            if(currHead == null)
            {
                currHead = newHead =  new ListNode(head1.val);
            } else {
                prevHead = currHead;
                currHead.next = new ListNode(head1.val);
                currHead = currHead.next;
            }
            head1 = head1.next;
        }

        while (head2!=null){
            if(currHead == null)
            {
                currHead = newHead =  new ListNode(head2.val);
            } else {
                prevHead = currHead;
                currHead.next = new ListNode(head2.val);
                currHead = currHead.next;
            }
            head2 = head2.next;
        }

        return newHead;
    }
}
