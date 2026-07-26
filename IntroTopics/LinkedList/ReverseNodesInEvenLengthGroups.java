public class ReverseNodesInEvenLengthGroups {
    // https://leetcode.com/problems/reverse-nodes-in-even-length-groups/

    public ListNode reverseEvenLengthGroups(ListNode head) {
        int count = 0;
        ListNode temp = head, prev = null;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        if(count <= 1) return head;

        int group = 1;
        temp = head;
        while(count > 0 && temp != null) {
            int nodes = count >= group ? group : count;
            count -= nodes;
            if((nodes & 1) == 1) {
                while(temp != null && nodes > 0) {
                    nodes--;
                    prev = temp;
                    temp = temp.next;
                }
            }
            else {
                ListNode back = null, curr = temp;
                while(temp != null && nodes > 0) {
                    nodes--;
                    ListNode next = temp.next;
                    temp.next = back;
                    back = temp;
                    temp = next;
                }
                prev.next = back;
                curr.next = temp;
                prev = curr;
            }
            group++;
        }
        return head;
    }
}
