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
      List<TreeNode> res;
    Map<String, Integer> map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<>();
        map = new HashMap<>();
        preorder(root);
        return res;
    }
    public String preorder(TreeNode root)
    {
        if(root == null)
        {
            return "N";
        }
        String left = preorder(root.left);
        String right = preorder(root.right);
        String cur = root.val +" "+ left +" "+ right;
        map.put(cur, map.getOrDefault(cur, 0)+1);
        if(map.get(cur) == 2)
            res.add(root);
        return cur;
    }
}