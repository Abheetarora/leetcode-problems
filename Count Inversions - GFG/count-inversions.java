// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.

public static long merge(long[] arr, long start, long mid, long end){
       long count=0;
       
       long l = mid - start + 1;
       long r = end - mid;

       long[] n1 = new long[(int) l];
       long[] n2 = new long[(int) r];

       for (int i = 0; i < l; ++i) n1[i] = arr[i + (int) start];
       for (int j = 0; j < r; ++j) n2[j] = arr[(int) mid + j + 1];

       int i = 0, j = 0;
       int k = (int)start;

           
       while (i < l && j < r) {
           if (n1[i] <= n2[j]) arr[k++] = n1[i++];
           else{  // (a[i] > a[j] and i < j)
               count+=l-i;    // ←------------------------------------------ change
               arr[k++] = n2[j++];
           }
       }

       while (i < l) {
           arr[k++] = n1[i++];
       }
       while (j < r) {
           arr[k++] = n2[j++];
       }


       return count;
   }

 

   public static long sort( long[] arr, long start, long end){

       long count=0;

       if(start<end){
           long mid = (start+end)/2;

           count += sort( arr, start, mid);
           count += sort( arr, mid+1, end);

           count += merge( arr, start, mid, end);
       }
       return count;
   }

   static long inversionCount(long arr[], long N)
   {
       return sort( arr, 0, N-1);
   }
}