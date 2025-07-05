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

    private int max;

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        List<Integer> candidates = List.of(
            root.val,
            root.val + left,
            root.val + right,
            root.val + left + right
        );
        max = Math.max(Collections.max(candidates), max);

        List<Integer> next = List.of(
            root.val,
            root.val + left,
            root.val + right
        );
        return Collections.max(next);
    }

    public int maxPathSum(TreeNode root) {
        max = -10000;
        helper(root);
        return max;
    }
}

