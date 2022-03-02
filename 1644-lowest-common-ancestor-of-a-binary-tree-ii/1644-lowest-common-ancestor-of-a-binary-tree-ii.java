/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count = 0;
    public boolean ispresent(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root == null)
        {
            return false;
        }
        if(root == p || root == q)
        {
            count++;
        }
        if(count == 2)
        {
            return true;
        }
        return (ispresent(root.left,p,q) || ispresent(root.right,p,q));
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(ispresent(root,p,q) == false)
      {
          return null;
      }
        return lca(root,p,q);
    }
    public TreeNode lca(TreeNode root,TreeNode p,TreeNode q)
    {
          if(root == null || root == p || root == q)
        {
            return root; 
        }
        TreeNode left = lca(root.left,p,q);
       TreeNode right = lca(root.right,p,q);
        if(left == null)
        {
            return right;
        }
        if(right == null)
        {
            return left;
        }
        else
        {
            return root;
        }
        
    }
}