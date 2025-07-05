/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    private static final String SEPARATOR = "~";
    private static final String NULL = "!";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        List<String> segments = new ArrayList<>();
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            boolean isNull = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();

                if (node == null) {
                    segments.add(NULL);
                    nodes.add(null);
                    nodes.add(null);
                    continue;
                }

                segments.add(String.valueOf(node.val));
                nodes.add(node.left);
                nodes.add(node.right);
                isNull = false;
            }

            if (isNull) {
                break;
            }
        }

        return String.join(SEPARATOR, segments);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] segments = data.split(SEPARATOR);
        return helper(0, segments);
    }

    private TreeNode helper(int index, String[] segments) {
        if (segments[index].equals(NULL)) {
            return null;
        }

        TreeNode current = new TreeNode(Integer.parseInt(segments[index]));
        current.left = helper(index * 2 + 1, segments);
        current.right = helper(index * 2 + 2, segments);
        return current;
    }
}

