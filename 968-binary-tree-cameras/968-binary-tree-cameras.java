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
    Set<TreeNode>st;
    public int minCameraCover(TreeNode root) {
        st = new HashSet<>();
        st.add(null);
        dfs(root,null);
        return ans;
    }
    public void dfs(TreeNode node,TreeNode parent)
    {
        if(node != null)
        {
            dfs(node.left,node);
            dfs(node.right,node);
            if((parent == null && !st.contains(node)) || !st.contains(node.left) || !st.contains(node.right))
            {
                ans++;
                st.add(node);
                st.add(parent);
                st.add(node.left);
                st.add(node.right);
            }
        }
    }
}