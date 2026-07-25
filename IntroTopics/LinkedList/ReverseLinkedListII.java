public class ReverseLinkedListII {
    // https://leetcode.com/problems/reverse-linked-list-ii/description/

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode leftList = null, temp = head;
        while(count < left - 1) {
            count++;
            temp = temp.next;
        }
        if(left > 1) {
            leftList = temp;
            count++;
            temp = temp.next;
            leftList.next = null;
        }
        ListNode prev = null, rightList = temp;
        while(temp != null && count <= right) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            count++;
        }
        if(leftList != null) leftList.next = prev;
        if(rightList != null) rightList.next = temp;
        return left == 1 ? prev : head;
    }
}