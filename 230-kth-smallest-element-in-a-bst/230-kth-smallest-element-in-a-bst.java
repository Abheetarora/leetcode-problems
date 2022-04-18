class Solution {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
         //Collections.sort(arr);
        return arr.get(k-1);
    }
    public void inorder(TreeNode root)
    {
        if(root == null)
        {
            return ;
        }
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
        return;
        
    }
}