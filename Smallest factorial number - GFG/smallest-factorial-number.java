// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int zeros(int mid){
int count =0;
while(mid!=0){
mid/= 5;
count +=mid;
}
return count;
}
    int findNum(int n)
    {
        int ans = 0;
        int lo = 0;
        int hi = n*5;
        while(hi>=lo)
        {
            int mid = (hi+lo)/2;
            if( zeros(mid)>=n )
            {
                ans = mid;
                hi = mid-1;
                
            }
            else if( zeros(mid)<n )
            {
                lo = mid+1;
            }
            
        }
        return ans;
        
        // Complete this function
    }
}