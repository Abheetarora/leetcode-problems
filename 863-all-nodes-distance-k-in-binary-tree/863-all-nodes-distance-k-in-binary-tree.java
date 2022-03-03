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
    HashMap<TreeNode,TreeNode>map = new HashMap<>();
    HashSet<TreeNode>visited = new HashSet<>();
    public void connectwithparents(TreeNode root,TreeNode parent)
    {
        if(root == null)
        {
            return;
        }
       // if(map.get(root)==null)
        map.put(root,parent);
        connectwithparents(root.left,root);
        connectwithparents(root.right,root);
    }
    public void dfs(TreeNode target,int k,ArrayList<Integer>res)
    {
        if(target==null)
        {
            return ;
        }
        if(visited.contains(target))
            return;
        visited.add(target);
        if(k==0)
        {
            res.add(target.val);
            return;
        }
        dfs(target.left,k-1,res);
        dfs(target.right,k-1,res);
        dfs(map.get(target),k-1,res);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer>res = new ArrayList<>();
        if(root == null)
        {
            return res;
        }
        connectwithparents(root,null);
        dfs(target,k,res);
        return res;
    }
}