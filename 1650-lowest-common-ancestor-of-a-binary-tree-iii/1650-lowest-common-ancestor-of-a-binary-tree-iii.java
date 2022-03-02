/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public void solve(Node p,HashSet<Node>map)
    {
        if(p == null)
        {
            return ;
        }
        map.add(p);
        solve(p.parent,map);
    }
     public Node result(Node p,HashSet<Node>map)
    {
         if(p == null)
         {
             return null;
         }
        if(map.contains(p))
        {
            return p;
        }
         Node ans = result(p.parent,map);
         return ans;
      
    }
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node>map = new HashSet<>();
        solve(p,map);
        Node ans = result(q,map);
        return ans;
    }
}