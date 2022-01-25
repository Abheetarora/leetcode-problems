// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static boolean checkstudents( int pages,int A[], int students) {
        int cnt = 0;
        int sumAllocated = 0; 
        for(int i = 0;i<A.length;i++) {
            if(sumAllocated + A[i] > pages) {
                cnt++; 
                sumAllocated = A[i];
                if(sumAllocated > pages) return false; 
            }
            else {
                sumAllocated += A[i];
            }
        }
        if(cnt < students) return true; 
        return false; 
    }
    // public static boolean checkstudents(int mid,int arr[],int m)
    // {
    //     int count = 1;
    //     int sum = 0;
    //     for(int i=0;i<arr.length;i++)
    //     {
    //         if(arr[i]>mid)
    //         {
    //             return false;
    //         }
    //       if(arr[i]+sum > mid)
    //       {
    //           count++;
    //           sum += arr[i];
    //       }
    //       else
    //       {
    //           sum += arr[i];
    //       }
            
    //     }
    //     if(count > m)
    //     {
    //         return false;
    //     }
    //     return true;
    // }
    public static int findPages(int[]arr,int n,int m)
    {
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
        }
        int lo = arr[0] ,hi = sum ;
        int result = -1;
        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            if(checkstudents(mid,arr,m) == true)
            {
                result = mid;
                hi = mid - 1;
            }
            else
            {
                lo = mid+1;
            }
        }
        return result;
        //Your code here
    }
};