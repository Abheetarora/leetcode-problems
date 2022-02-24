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
     ArrayList<Integer>arr;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
      arr = new ArrayList<Integer>();
        if(root == null)
        {
            return arr;
        }
        if(root.left!=null || root.right!=null)
        {
            arr.add(root.val);
        }
        leftnodes(root.left);
         leafnodes(root);
        rightnodes(root.right);
       
        return arr;
    }
    public void leftnodes(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        if(root.left!=null || root.right!=null)
        {
            arr.add(root.val);
        }
        if(root.left == null)
        {
            leftnodes(root.right);
        }
        leftnodes(root.left);
        
    }
    public void rightnodes(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
       
        if(root.right == null)
        {
            rightnodes(root.left);
        }
        rightnodes(root.right);
         if(root.left!=null || root.right!=null)
        {
            arr.add(root.val);
        }
        
    }
    public void leafnodes(TreeNode root)
    {
        if(root == null)
        {
            return ;
        }
        if(root.right == null && root.left == null)
        {
            arr.add(root.val);
        }
        leafnodes(root.left);
        leafnodes(root.right);
    }
}