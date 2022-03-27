// { Driver Code Starts
//Initial Template for Java//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Solution ob = new Solution();
            int ans  = ob.palindromicNumbers(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static boolean check(String s)
   {
       int i=0;
       int j=s.length()-1;
       while(i<j)
       {
           if(s.charAt(i)!=s.charAt(j))
           {
               return false;
           }
           i++;
           j--;
       }
       return true;
   }
   static int palindromicNumbers(int n)
   {
      if(n>=1 && n<=9)
      {
          return n-1;
      }
      
      int count=9;
      for(int i=10;i<n;i++)
      {
          String s =i+"";
          if(check(s))
          {
              count++;
          }
      }
      return count;
   }
}