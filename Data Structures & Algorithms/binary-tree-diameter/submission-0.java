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
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return max - 1; // nodes=edges+1, i.e; edges=nodes-1
    }
    
    private int diameterOfBinaryTreeHelper(TreeNode root) {
        // Base Condition
        if (root == null) {
            return 0;
        }
        
        int ldia = diameterOfBinaryTreeHelper(root.left);
        int rdia = diameterOfBinaryTreeHelper(root.right);
        // We have two choices here:
        // 1. The path passes from the root node.
        // 2. The path does not pass from the root node. 
        int temp = Math.max(ldia, rdia) + 1; // Choice 1
        max = Math.max(max, ldia + rdia + 1); // Choice 2
        // Return temp bcoz the function ultimately needs to return the value to its upper parent
        // in the tree
        return temp;
    }
}