// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        return poo(str);
        // code here
    }
     public static int poo(String s) {
        StringBuilder sb=new StringBuilder(s);  
    sb.reverse();  
    //return sb.toString();  
        int ans = longestCommonSubsequence(s,sb.toString());
        return s.length() - ans;
        
    }
       public static int longestCommonSubsequence(String text1, String text2) 
    {
        int arr[][] = new int[text1.length()+1][text2.length()+1];
        for(int[] x:arr)
        Arrays.fill(x,  -1);
        return lcs(text1,text2,text1.length(),text2.length(),arr);
    }
    public static int lcs(String s1,String s2,int m,int n,int [][] arr)
    {
        if(arr[m][n]!=-1)
            return arr[m][n];
        if(m==0||n==0)
        return 0;
        else
        {
            if(s1.charAt(m-1)==s2.charAt(n-1))
            arr[m][n] = 1+lcs(s1,s2,m-1,n-1,arr);
            else
            arr[m][n] = Math.max(lcs(s1,s2,m-1,n,arr),lcs(s1,s2,m,n-1,arr));
        }
        return arr[m][n];
    }
}