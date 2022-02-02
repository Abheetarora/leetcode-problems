// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        if( solve(A,B) == true )
        {
            return 1;
        }
        return 0;
        //code here
    }
      public static boolean solve(String s, List<String> wordDict) {
        return ans(s,new HashSet<>(wordDict),0,new Boolean[s.length()]);
    }
    public static boolean ans(String s,Set<String>dict , int start,Boolean[]dp)
    {
        if(start == s.length())
        {
            return true;
        }
        if(dp[start]!=null)
        {
            return dp[start];
        }
        for(int i=start+1;i<=s.length();i++)
        {
            if(dict.contains(s.substring(start,i)) && ans(s,dict,i,dp))
            {
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}