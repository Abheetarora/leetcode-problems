// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        return trap(arr);
    } 
        public static long trap(int[] height) {
        //find the max left and max right from a particular positiom
        int maxL[] = new int[height.length];
        int maxR[] = new int[height.length];
        int n = height.length;
        maxL[0] = height[0];
        for(int i = 1;i<n;i++)
        {
            maxL[i] = Math.max(maxL[i-1],height[i]);
        }
        maxR[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            maxR[i] = Math.max(maxR[i+1],height[i]);
        }
        long ans = 0;
       
        for(int i=0;i<n;i++)
        {
            ans = ans + Math.min(maxR[i] , maxL[i]) - height[i];
        }
        return ans;
    }
}


