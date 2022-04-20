class BSTIterator {
    int size;
    ArrayList<Integer> A;
    public BSTIterator(TreeNode root) {
      this.A = new ArrayList<>();
      this.size = 0;
      this.dfs(root);
    }
    
    public void dfs(TreeNode root){
       if(root == null) return;
       this.dfs(root.left);
       this.A.add(root.val);
       this.dfs(root.right);
    }
    
    public int next() {
        return this.A.get(size++);
    }
    
    public boolean hasNext() {
        if(this.size + 1 <= this.A.size())
         return true;
        else
         return false;
    }
}