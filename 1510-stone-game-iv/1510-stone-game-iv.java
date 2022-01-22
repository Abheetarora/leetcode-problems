class Solution {
    public boolean winnerSquareGame(int n) {
        int dp[]= new int[n+1];
        for(int i=0;i<=n;i++)
        {
            dp[i] = -1;
        }
        int ans = solve(dp,n);
        if(ans == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
            }
    public static int solve(int dp[],int n)
    {
       if(dp[n] != -1)
       {
           return dp[n];
       }
        int sr = (int)Math.sqrt(n);
        for(int i =1;i<=sr;i++)
        {
            if(solve(dp,n-i*i)==0)
            {
                dp[n]=1;
                return 1;
            }
        }
        dp[n] = 0;
        return 0;
    }
}