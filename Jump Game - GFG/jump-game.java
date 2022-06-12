// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] A, int N) {
        // code here
        if(canJump(A)==true)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
     public static boolean canJump(int[] nums) {
        return canJump(nums, 0, new Boolean[nums.length + 1]);
    }
    
    public static boolean canJump(int[] nums, int index, Boolean[] dp) {
        if(index == nums.length - 1) {
            return true;
        }
        
        if(dp[index] != null) {
            return dp[index];
        }
        
        int n = nums[index];
        for(int i = n; i > 0; i--) {
            if(index + i < nums.length && canJump(nums, index + i, dp)){
                dp[index] = true;
                return true;
            }
        }
        
        dp[index] = false;
        return false;
    }
};