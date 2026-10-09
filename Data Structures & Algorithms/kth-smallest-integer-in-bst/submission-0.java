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
    List<Integer> inorder = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, inorder);
        return inorder.get(k-1);
    }

    void dfs(TreeNode root, List<Integer> inorder) {
        if (root == null)
            return;
        dfs(root.left, inorder);
        inorder.add(root.val);
        dfs(root.right, inorder);
    }
}
