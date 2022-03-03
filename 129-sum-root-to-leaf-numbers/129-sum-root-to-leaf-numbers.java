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
    public void solve(TreeNode root,int num)
    {
        if(root == null)
        {
            return;
        }
        num = num*10 + root.val;
        if(root.left == null && root.right == null)
        {
            ans+=num;
        }
        solve(root.left,num);
        solve(root.right,num);
    }
    public int sumNumbers(TreeNode root) {
        solve(root,0);
        return ans;
    }
}