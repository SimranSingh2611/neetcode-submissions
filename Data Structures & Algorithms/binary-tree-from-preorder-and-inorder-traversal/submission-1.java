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
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);
        
        return arrayToTree(preorder, 0, inorder.length-1, inorderIndexMap);
    }

    private TreeNode arrayToTree(int[] preorder, int inStart, int inEnd, Map<Integer, Integer> inorderIndexMap) {

        if (inStart > inEnd)
            return null;
        
        int rootVal = preorder[preorderIndex];
        preorderIndex++;
        TreeNode root = new TreeNode(rootVal);

        root.left = arrayToTree(preorder, inStart, inorderIndexMap.get(rootVal)-1, inorderIndexMap);

        root.right = arrayToTree(preorder, inorderIndexMap.get(rootVal)+1, inEnd, inorderIndexMap);

        return root;
    }
}