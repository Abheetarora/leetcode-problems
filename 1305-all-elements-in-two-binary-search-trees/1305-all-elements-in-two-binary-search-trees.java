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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        var result = new ArrayList<Integer>();
        
        inorder(root1, result);
        inorder(root2, result);
        
        Collections.sort(result);
        return result;
    }
    
    private void inorder(TreeNode root, List<Integer> arr) {
        if (root == null) return;
       
        inorder(root.left, arr);
		arr.add(root.val);
        inorder(root.right, arr);
    }
}