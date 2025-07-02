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
    private int length(ListNode head) {
        return head == null ? 0 : length(head.next) + 1;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int target = length(head) - n;
        if (target == 0) {
            return head.next;
        }

        ListNode current = head;
        for (int i = 0; i < target - 1; i++) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
        return head;
    }
}

