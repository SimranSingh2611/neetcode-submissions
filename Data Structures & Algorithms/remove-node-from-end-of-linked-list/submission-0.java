class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode right = dummy;
        int k = n;

        // Move right n+1 steps ahead
        while (right != null && k >= 0) {
            right = right.next;
            k--;
        }

        ListNode left = dummy;

        while (right != null) {
            right = right.next;
            left = left.next;
        }

        // Remove left.next
        ListNode nodeToBeRemoved = left.next;
        left.next = nodeToBeRemoved.next;

        return dummy.next;
    }
}