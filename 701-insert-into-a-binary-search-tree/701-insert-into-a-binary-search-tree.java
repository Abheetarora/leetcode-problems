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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return solve(root,val);
    }
    public TreeNode solve(TreeNode root, int val) {
        if(root == null)
        {
            TreeNode a = new TreeNode(val);
            root = a;
            return root;
        }
        else if(root.val<val)
        {
            if(root.right==null)
            {
                TreeNode a = new TreeNode(val);
            root.right = a;
            return root;
            }
            else
            {
                 solve(root.right,val);
            }
        }
        else
        {
            if(root.left==null)
            {
                TreeNode a = new TreeNode(val);
            root.left = a;
            return root;
            }
            else
            {
                 solve(root.left,val);
            }
        }
        return root;
    }
}