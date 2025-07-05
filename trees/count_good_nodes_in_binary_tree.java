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
    private int helper(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int count = root.val >= max ? 1 : 0;
        max = Math.max(root.val, max);
        count += helper(root.left, max) + helper(root.right, max);
        return count;
    }

    public int goodNodes(TreeNode root) {
        return helper(root, -1000);
    }
}

