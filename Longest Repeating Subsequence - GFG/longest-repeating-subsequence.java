// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int dp[][] = new int[str.length()][str.length()];
        for(int i=0;i<str.length();i++)
        {
            for(int j=0;j<str.length();j++)
            {
                dp[i][j] = -1;
            }
        }
        return ans(str,str,str.length(),str.length(),dp);
        // code here
    }
    public int ans(String s,String t,int n,int m,int[][]dp)
    {
        if(m==0 || n ==0)
        {
            return 0;
        }
        if(dp[n-1][m-1]!=-1)
        {
            return dp[n-1][m-1];
        }
        else if(s.charAt(n-1)==t.charAt(m-1) && m!=n)
        {
           return dp[n-1][m-1] = 1 + ( ans(s,t,n-1,m-1,dp) );
        }
        else
        {
           return dp[n-1][m-1] = Math.max(ans(s,t,n-1,m,dp),ans(s,t,n,m-1,dp));
        }
    }
}