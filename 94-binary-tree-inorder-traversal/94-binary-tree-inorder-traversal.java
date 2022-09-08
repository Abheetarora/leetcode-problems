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
private class Pair
    {
        TreeNode node;
        int state;
        Pair(TreeNode node,int state)
        {
            this.node = node;
            this.state = state;
        }
        
    }
    public List<Integer> inorderTraversal(TreeNode root) {
      Stack<Pair> st = new Stack<Pair>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(root == null)
        {
            return arr;
        }
        st.push(new Pair(root,1));
        while(!st.isEmpty())
       {
            Pair top = st.peek();
            int state = top.state;
            TreeNode node = top.node;
            if(state ==1)
            {
               
             if(node.left!=null)
             {
                 st.push(new Pair(node.left,1));
             }
                top.state++;
            }
            else if(state == 2)
            {
                arr.add(node.val);
             if(node.right!=null)
             {
                  st.push(new Pair(node.right,1));
             }
                top.state++;
            }
            else
            {
                 
                st.pop();
            }      
        }
         return arr;
    }
}