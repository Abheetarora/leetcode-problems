// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String s)
    {
           int n = s.length();
        if(n%2!=0) return -1;
        int len = Integer.MAX_VALUE;
        
        while(s.length()<len)
        {
            len = s.length();
            s = s.replace("{}", "");
        }
        int c1=0, c2=0;
        
        for(int i=0; i<len; i++)
        {
            if(s.charAt(i)=='{') c1++;
            else c2++;
        }
        
        return (c1/2)+(c2/2)+(c1%2)+(c2%2);
        // your code here       
    }
}