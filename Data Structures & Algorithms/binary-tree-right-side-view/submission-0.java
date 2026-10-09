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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> out = new ArrayList<>();
        if (root == null)
            return out;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while(size > 0) {
                TreeNode tn = q.remove();
                level.add(tn.val);

                if (tn.left != null)
                    q.add(tn.left);
                if (tn.right != null)
                    q.add(tn.right);
                
                size--;
            }
            out.add(level.get(level.size() - 1));
        }
        return out;
    }
}
