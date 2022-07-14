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
     public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        
        return help(preorder, inorder, 0, n-1, 0,n-1);
    }
    public TreeNode help(int[] preorder, int[] inorder, int inS, int inE, int preS,int preE){
        
      if(inS > inE)
      {
          return null;
      }
    int rootdata=preorder[preS];
    int rootIndex=-1;
      
    for(int i=inS;i<=inE;i++){
        if(inorder[i] == rootdata)
        {
            rootIndex =i;
            break;
        }
    
    }
    int lins =inS;
    int line =rootIndex-1;
    int lpres =preS+1;
    int lpree =line-lins+lpres;
    int rpres =lpree+1;
    int rpree =preE;
    int rins =rootIndex+1;
    int rine =inE;
    
     TreeNode root = new TreeNode(rootdata);
    root.left = help(preorder,inorder,lins,line,lpres,lpree);
    root.right = help(preorder,inorder,rins,rine,rpres,rpree);
         
     
        return root;
    }}