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
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
         solve(root,low,high);
        return ans;
    }
    public void solve(TreeNode root,int l,int h)
    {
        if(root == null)
        {
            return;
        }
        if(root.val >= l && root.val <= h)
            ans+=root.val;
        solve(root.left,l,h);
        solve(root.right,l,h);
        
    }
}