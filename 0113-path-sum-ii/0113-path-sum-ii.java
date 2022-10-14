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
    public void solve(TreeNode root,List<List<Integer>>ans,List<Integer>smallans,int sum)
    {
        if(root == null)
        {
            return;
        }
        smallans.add(root.val);
        if(root.left == null && root.right == null && sum == root.val)
        {
            ans.add(new ArrayList<>(smallans));
        }
        else
        {
            solve(root.left,ans,smallans,sum-root.val);
            solve(root.right,ans,smallans,sum-root.val);
        }
        smallans.remove(smallans.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>smallans = new ArrayList<>();
        solve(root,ans,smallans,targetSum);
        return ans;
    }
}