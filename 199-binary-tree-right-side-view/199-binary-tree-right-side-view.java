class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
        {
            return result;
        }
        Queue <TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i =0;i<size;i++)
            {
                
                TreeNode current = q.remove();
                if(i==size-1)
                {
                  result.add(current.val);  
                }
                if(current.left!=null)
                {
                   q.add(current.left); 
                }
                if(current.right!=null)
                {
                    q.add(current.right);
                }
            }
        }
        return result;
    }
}