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
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode next = head.next;
        if (next == null) {
            return head;
        }

        head.next = null;
        ListNode reversed = reverse(next);
        next.next = head;
        return reversed;
    }

    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reversed = reverse(slow.next);
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (reversed != null) {
            tail.next = head;
            tail = tail.next;
            head = head.next;

            tail.next = reversed;
            tail = tail.next;
            reversed = reversed.next;
        }

        if (head == slow) {
            tail.next = head;
            tail = tail.next;
        }
        tail.next = null;
    }
}

