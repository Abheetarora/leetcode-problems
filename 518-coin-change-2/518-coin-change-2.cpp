// class Solution {
// public:
//     int change(int amount, vector<int>& coins) {
        
//     }
// };
class Solution {
public:
    int dp[300][5001];
   
     
    
    int solve(vector<int> &coins,int n,int amount){
        if(amount==0){
            return 1;
        }
        
        if(n==0){
            return 0;
        }
        
        if(dp[n][amount]!=-1){
            return dp[n][amount];
        }
        
        if(coins[n-1]<=amount){
            return dp[n][amount]=solve(coins,n-1,amount)+solve(coins,n,amount-coins[n-1]);
        }
        
        else
            return dp[n][amount]=solve(coins,n-1,amount);
        
        
    }
    int change(int amount, vector<int>& coins) {
           memset(dp,-1,sizeof(dp));
        int n=coins.size();
        return solve(coins,n,amount);
    }
};