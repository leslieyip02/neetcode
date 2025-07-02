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
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> previous = new Stack<>();
        ListNode current = head;
        while (previous.size() < k) {
            if (current == null) {
                return head;
            }
            previous.push(current);
            current = current.next;
        }

        ListNode reversed = previous.pop();
        ListNode tail = reversed;
        while (!previous.empty()) {
            tail.next = previous.pop();
            tail = tail.next;
        }
        tail.next = reverseKGroup(current, k);
        return reversed;
    }
}

