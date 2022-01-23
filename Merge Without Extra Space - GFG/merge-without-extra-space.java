// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i] + " ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i] + " ");
            }
            System.out.println(str);
        }
    }
}// } Driver Code Ends


class Solution {
    public void merge(int a[], int b[], int n, int m) {
        // code here
        int count = 0;
        int k = n;
        int i = 0;
        int j = 0;
        while(k-->0 && i<n && j<m)
        {
            if(a[i]<b[j])
            {
                i++;
            }
            else
            {
                count++;
                j++;
            }
        }
        for(int q=0;q<count;q++)
        {
            int p = b[q];
            int o = a[n-q-1];
            int u = p;
            p = o;
            o = u;
             b[q] = p;
             //System.out.println(b[q]);
             a[n-q-1] = o;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        
    }
}