package medium;

public class DesignBrowserHistory {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }

    static
    class BrowserHistory {

        int index;

        ListNode curr;

        public BrowserHistory(String homepage) {
            this.index = 0;
            this.curr = new ListNode(homepage);
        }

        public void visit(String url) {
            ListNode newNode = new ListNode(url);

            if(curr.next != null){
                curr.next.prev = null;
            }
            curr.next = newNode;
            newNode.prev = curr;

            curr = newNode;
            index++;
        }

        public String back(int steps) {
            int i = 0;
            while (i<steps){
                if(curr.prev != null){
                    curr = curr.prev;
                } else {
                    break;
                }

                i++;
            }

            index-=i;

            return curr.val;
        }

        public String forward(int steps) {
            int i = 0;
            while (i<steps){
                if(curr.next != null){
                    curr = curr.next;
                } else {
                    break;
                }

                i++;
            }

            index+=i;

            return curr.val;
        }


        class ListNode {
            String val;
            ListNode next;
            ListNode prev;

            public ListNode(String val) {
                this.val = val;
            }

            public ListNode(ListNode next, ListNode prev) {
                super();
                this.next = next;
                this.prev = prev;
            }
        }
    }
}
