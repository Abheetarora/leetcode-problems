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
    private int square(int n) {
        return n * n;
    }
 
    public int solveWordWrap (int[] nums, int k)
    {
        int[][] memo = new int[nums.length][k + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return solveWordWrapUsingMemo(nums, nums.length, k, 0, k, memo);
        // Code here 
    }
    
    private int solveWordWrap(int[] words, int n, int length, int wordIndex, int remLength, int[][] memo) {
 
        //base case for last word
        if (wordIndex == n - 1) {
            memo[wordIndex][remLength] = words[wordIndex] < remLength ? 0 : square(remLength);
            return memo[wordIndex][remLength];
        }
 
        int currWord = words[wordIndex];
        //if word can fit in the remaining line
        if (currWord < remLength) {
            return Math.min(
                    //if word is kept on same line
                    solveWordWrapUsingMemo(words, n, length, wordIndex + 1, remLength == length ? remLength - currWord : remLength - currWord - 1, memo),
                    //if word is kept on next line
                    square(remLength) + solveWordWrapUsingMemo(words, n, length, wordIndex + 1, length - currWord, memo)
            );
        } else {
            //if word is kept on next line
            return square(remLength) + solveWordWrapUsingMemo(words, n, length, wordIndex + 1, length - currWord, memo);
        }
    }
 
    private int solveWordWrapUsingMemo(int[] words, int n, int length, int wordIndex, int remLength, int[][] memo) {
        if (memo[wordIndex][remLength] != -1) {
            return memo[wordIndex][remLength];
        }
 
        memo[wordIndex][remLength] = solveWordWrap(words, n, length, wordIndex, remLength, memo);
        return memo[wordIndex][remLength];
    }
    public int ans (int dp[][],int nums[],int k,int i,int rem )
    {
        if(i == nums.length-1)
        {
           dp[i][rem] = nums[i] < rem ? 0 : (int)Math.pow(rem,2); 
        }
        int cur = nums[i];
        if(cur < rem)
        {
            //  int ans1 = 0;//agr same line mei addition krni ho
            //  int ans2 = 0;//agr doosri line mei jaana ho
            //  ans1 = check( dp,nums,k,i+1,rem == k ? rem-cur : rem-cur-1 );
            //  ans2 = (int)Math.pow(rem,2) + check( dp,nums,k,i+1,k-cur );
            //  return Math.min(ans1,ans2);
           return Math.min(
                    //if word is kept on same line
                    check( dp,nums,k,i+1,rem == k ? rem-cur : rem-cur-1 ),
                    //if word is kept on next line
                    (int)Math.pow(rem,2) + check( dp,nums,k,i+1,k-cur )
            );
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