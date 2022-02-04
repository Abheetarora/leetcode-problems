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
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minimumNumberOfSwaps(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int minimumNumberOfSwaps(String s){
        int count = 0,k = 0;
      for(int i=0;i<s.length();i++)
      {
          if(s.charAt(i)==']')
          {
              k--;
          }
          else if(s.charAt(i) == '[')
          {
              if(k>=0)
              {
                  k++;
              }
              else
              {
                  count = count + (-1*k);
                  k++;
                  
              }
          }
      }
      return count;
    }
}