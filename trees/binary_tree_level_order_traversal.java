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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversed = new ArrayList<>();       
        if (root == null) {
            return traversed;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                level.add(node.val);

                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right!= null) {
                    nodes.add(node.right);
                }
            }
            traversed.add(level);
        }
        return traversed;
    }
}

