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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
         if(root == null )
        {
            return root; 
        }
        
        for(int i=0;i<nodes.length;i++)
        {
            if(root == nodes[i])
                return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,nodes);
       TreeNode right = lowestCommonAncestor(root.right,nodes);
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