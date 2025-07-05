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
    private TreeNode helper(
        List<Integer> preorder,
        List<Integer> inorder
    ) {
        if (preorder.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(preorder.get(0));
        int split = inorder.indexOf(root.val);
        int leftSize = split;

        root.left = helper(
            preorder.subList(1, leftSize + 1),
            inorder.subList(0, split)
        );
        root.right = helper(
            preorder.subList(leftSize + 1, preorder.size()),
            inorder.subList(split + 1, inorder.size())
        );
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(
            Arrays.stream(preorder).boxed().toList(),
            Arrays.stream(inorder).boxed().toList()
        );
    }
}

