class Solution {
    List<Integer> res;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left != null || root.right != null) {
            res.add(root.val);   
        }
        addLeft(root.left);
        addLeaves(root);
        addRight(root.right);
        return res;
    }
    
    private void addLeft(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            res.add(root.val);   
        }
        if (root.left == null) {
            addLeft(root.right);
        }
        addLeft(root.left);
    }
    
    private void addRight(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right == null) {
            addRight(root.left);
        }
        addRight(root.right);
        if (root.left != null || root.right != null) {
            res.add(root.val);   
        }
    }
    
    private void addLeaves(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        addLeaves(root.left);
        addLeaves(root.right);
    }
}