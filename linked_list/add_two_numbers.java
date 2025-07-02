/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        int carry = 0;
        while (!(l1 == null && l2 == null)) {
            if (l1 == null) l1 = new ListNode(0);
            if (l2 == null) l2 = new ListNode(0);

            int current = l1.val + l2.val + carry;
            tail.next = new ListNode(current % 10);
            carry = current / 10;

            l1 = l1.next;
            l2 = l2.next;
            tail = tail.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(1);
        }

        return dummy.next;
    }
}

