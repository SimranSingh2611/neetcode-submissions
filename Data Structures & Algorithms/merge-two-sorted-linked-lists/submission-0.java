class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode newList = dummy;

        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while (curr1 != null && curr2 != null) {

            if (curr1.val <= curr2.val) {
                newList.next = curr1;
                curr1 = curr1.next;
            } else {
                newList.next = curr2;
                curr2 = curr2.next;
            }

            newList = newList.next;
        }

        // Attach the remaining list
        if (curr1 != null) {
            newList.next = curr1;
        }

        if (curr2 != null) {
            newList.next = curr2;
        }

        return dummy.next;
    }
}