// { Driver Code Starts
//Initial Template for Java

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
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
   {
       // your code here
       TreeMap<String,Integer> map=new TreeMap<String,Integer>();
       for(String i:arr)
       {
           if(map.containsKey(i))
           {
               map.put(i,map.get(i)+1);
           }
           else
           {
             map.put(i,1);
           }
       }
       String key=null;
       int maxV=Integer.MIN_VALUE;
       for(Map.Entry<String,Integer> m:map.entrySet())
       {
           if(maxV < m.getValue())
           {
               maxV=m.getValue();
               key=m.getKey();
           }
       }
       map.remove(key);
       String k=null;
       int mx=Integer.MIN_VALUE;
       for(Map.Entry<String,Integer> m:map.entrySet())
       {
           if(mx < m.getValue())
           {
               mx=m.getValue();
               k=m.getKey();
           }
       }
       return k;
   }
}