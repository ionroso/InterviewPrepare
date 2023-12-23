package easy;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(5);
        l.next.next.next.next = new ListNode(1);

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(l));
    }
    private static   class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return true;

        Stack<Integer> stack = new Stack<>();
        ListNode p = head;

        int i = 0;
        while (p != null){
            stack.push(p.val);
            p = p.next;
            i++;
        }

        i = i/2;
        while (i>0){
           if(head.val!= stack.pop())
               return false;
           head = head.next;
           i--;
        }

        return true;
    }
}
