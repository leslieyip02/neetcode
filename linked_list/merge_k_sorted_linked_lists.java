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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });
        for (ListNode list : lists) {
            pq.add(list);
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode current = pq.poll();
            tail.next = current;

            if (current.next != null) {
                pq.add(current.next);
            }
            current.next = null;
            tail = tail.next;
        }
        return dummy.next;
    }
}

