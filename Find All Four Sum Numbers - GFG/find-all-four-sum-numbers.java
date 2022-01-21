// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
   public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr); 
        int l,r;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n-3;i++){
            if(i>0 && arr[i]==arr[i-1])
            continue;
        // code here
        for(int j=i+1;j<n-2;j++)
        {
            if(j>i+1 && arr[j]==arr[j-1])
            continue;
            l = j+1;
            r= n-1;
            while(l<r)
            {
               int oldl=l;
               int oldr=r;
               if(arr[l]+arr[r]+arr[i]+arr[j]==k)
               {
                   ArrayList<Integer> smallans = new ArrayList<>();
                   smallans.add(arr[i]);
                   smallans.add(arr[j]);
                   smallans.add(arr[l]);
                   smallans.add(arr[r]);
                   ans.add(smallans);
               
                   while(l<r && arr[l]== arr[oldl]) l++;
                   while(l<r && arr[r]==arr[oldr]) r--;
               }
               else if(arr[l]+arr[r]+arr[i]+arr[j]<k )
               {
                   l++;
               }
               else
               r--;
               
            }
        }
        }
        return ans;
    }
}