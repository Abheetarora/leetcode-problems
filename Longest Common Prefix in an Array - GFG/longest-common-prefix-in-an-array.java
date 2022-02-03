// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String s[], int n){
        // code here
    
           int ans = Integer.MAX_VALUE;
       for(int i=0;i<s.length;i++)
       {
           int j = 0;
           int mn = Math.min(s[0].length(),s[i].length());
           //System.out.println(mn + s[i]);
           while( mn > 0 && s[i].charAt(j) == s[0].charAt(j))
           {
               
               j++;
               mn--;
           }
           
           ans = Math.min(ans,j);
       }
        if(ans == 0)
        {
            return "-1";
        }
        return s[0].substring(0,ans);
    }
    
}