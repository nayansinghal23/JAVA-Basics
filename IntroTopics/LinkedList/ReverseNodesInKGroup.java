public class ReverseNodesInKGroup {
    // https://leetcode.com/problems/reverse-nodes-in-k-group/description/

    private ListNode reverseLL(ListNode head, int k) {
        ListNode prev = null, curr = head;
        int count = 0;
        while(head != null && count < k) {
            count++;
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        if(head != null) {
            curr.next = reverseLL(head, k);
        }
        if(count < k && head == null) {
            head = prev;
            ListNode back = null;
            while(head != null) {
                ListNode next = head.next;
                head.next = back;
                back = head;
                head = next;
            }
            return curr;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseLL(head, k);
    }
}
