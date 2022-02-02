// { Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        int dp[][] = new int[nums.length][k+1];
         for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return ans(dp,nums,k,0,k);
        // Code here 
    }
    public int ans (int dp[][],int nums[],int k,int i,int rem )
    {
        if(i == nums.length-1)
        {
           return dp[i][rem] = nums[i] < rem ? 0 : (int)Math.pow(rem,2); 
        }
        int cur = nums[i];
        if(cur < rem)
        {
             int ans1 = 0;//agr same line mei addition krni ho
             int ans2 = 0;//agr doosri line mei jaana ho
             ans1 = check( dp,nums,k,i+1,rem == k ? rem-cur : rem-cur-1 );
             ans2 = (int)Math.pow(rem,2) + check( dp,nums,k,i+1,k-cur );
             return Math.min(ans1,ans2);
        }
        else
        {
             return (int)Math.pow(rem,2) + check( dp,nums,k,i+1,k-cur );
        }
    }
    public int check(int dp[][],int nums[],int k,int i,int rem)
    {
        if(dp[i][rem]!=-1)
        {
            return dp[i][rem];
        }
        return dp[i][rem] = ans(dp,nums,k,i,rem);
    }
    
}