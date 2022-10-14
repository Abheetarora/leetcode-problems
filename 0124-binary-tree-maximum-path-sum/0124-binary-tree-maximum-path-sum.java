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
     int mx = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       
     int sol = solve(root);
        return mx;
    }
    public int solve(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int l = 0;
        int r = 0;
        if(root.left!=null)
        {
           l = Math.max(0,solve(root.left));
        }
        if(root.right!=null)
        {
            r = Math.max(0,solve(root.right));
        }
        mx = Math.max(mx,l+r+root.val);
        return Math.max(l,r)+root.val;
        
    }
}