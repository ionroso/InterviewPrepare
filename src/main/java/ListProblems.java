public class ListProblems {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);

        ListNode printRoot = reverseList(head);
        while (printRoot != null)
        {
            System.out.print(printRoot.val);
            System.out.print(" ");
            printRoot = printRoot.next;
        }
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode reverseList(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;

        while (curr!= null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
