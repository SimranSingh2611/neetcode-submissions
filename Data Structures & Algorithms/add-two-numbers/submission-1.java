class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        ListNode dummy = new ListNode(-1);
        ListNode newList = dummy;

        while (l1 != null || l2 != null) {

            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = carry + val1 + val2;

            int d = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(d);
            newList.next = node;
            newList = newList.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            ListNode node = new ListNode(carry);
            newList.next = node;
        }

        return dummy.next;
    }
}