class Solution {
    public int[] constructArray(int n, int k) {
        // int p=1;
        // int j=n;
        // int arr[] = new int[n];
        // int i=0;
        // for(i=0;i<k;)
        // {
        //     if(i%2==0)
        //     arr[i++] = p++;
        //     else
        //     arr[i++] = j--;
        // }
        // while(i<n)
        // {
        //     arr[i++] = p++;
        // }
        // return arr;
          int[] ans = new int[n];
        int c = 0;
        for (int v = 1; v < n-k; v++) {
            ans[c++] = v;
        }
        for (int i = 0; i <= k; i++) {
            ans[c++] = (i%2 == 0) ? (n-k + i/2) : (n - i/2);
        }
        return ans;
    }
}