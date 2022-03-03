class Solution {
public:
    int pathSum(TreeNode* root, int sum) {
        
        if(root == nullptr){return 0;}
        return  pathSum(root->left, sum) + pathSum(root->right, sum) + dfs(root, sum);          
    }
    
    int dfs(TreeNode* root, int sum)
    {
        if(root == nullptr){return 0;}
        
        int count = 0;
        if(root->val == sum){ ++count;}
        count += dfs(root->left, sum-root->val);
        count += dfs(root->right, sum-root->val);
        return count;
    }
};