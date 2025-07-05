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

    private List<Integer> values;

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);
        values.add(root.val);
        helper(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        values = new ArrayList<>();
        helper(root);
        return values.get(k - 1);
    }
}

