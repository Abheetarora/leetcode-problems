// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
 

static class pair implements Comparable<pair>{
       int li;
       int di;
       int val;
       pair(int li,int di,int val){
           this.li=li;
           this.di=di;
           this.val=val;
       }
       public int compareTo(pair o){
           return this.val-o.val;
       }
       
   }
   public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
   {
       // Write your code here.
       ArrayList<Integer> al = new ArrayList<>();
       PriorityQueue<pair> pq = new PriorityQueue<>();
       for(int i=0;i<arr.length;i++){
           pair p = new pair(i,0,arr[i][0]);
           pq.add(p);
           
       }
       while(!pq.isEmpty()){
           pair rp=pq.remove();
           al.add(rp.val);
           rp.di++;
           if(rp.di<arr[rp.li].length){
               rp.val=arr[rp.li][rp.di];
              pq .add(rp);
           }
       }
       
       return al;
   }
}