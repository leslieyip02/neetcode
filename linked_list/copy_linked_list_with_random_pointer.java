/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Integer> indices = new HashMap<>();
        List<Node> nodes = new ArrayList<>();

        int i = 0;
        Node current = head;
        while (current != null) {
            indices.put(current, i);
            i++;

            nodes.add(new Node(current.val));
            current = current.next;
        }

        current = head;
        for (int j = 0; j < nodes.size(); j++) {
            if (j < nodes.size() - 1) {
                nodes.get(j).next = nodes.get(j + 1);
            }
            if (current.random != null) {
                int index = indices.get(current.random);
                nodes.get(j).random = nodes.get(index);
            }
            current = current.next;
        }
        return nodes.get(0);
    }
}

