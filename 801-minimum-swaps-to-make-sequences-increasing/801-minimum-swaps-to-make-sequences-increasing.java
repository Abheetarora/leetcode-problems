class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int arr1[] = new int[nums1.length+1];
        int arr2[] = new int[nums2.length+1];
        arr1[0] = -1;
        arr2[0] = -1;
        for(int i=1;i<=nums1.length;i++)
        {
            arr1[i] = nums1[i-1];
            arr2[i] = nums2[i-1];
        }
        int dp[][] = new int[arr1.length+1][2];
        for(int i=0;i<arr1.length;i++)
        {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return solve(arr1,arr2,1,0,dp);
        
    }
    public int solve(int[] arr1,int[] arr2,int index,int swap,int dp[][])
    {
        if(index == arr1.length)
        {
            return 0;
        }
        if(dp[index][swap]!=-1)
        {
            return dp[index][swap];
        }
        int ans = Integer.MAX_VALUE;
        int p1 = arr1[index-1];
        int p2 = arr2[index-1];
        if(swap == 1)
        {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }
        if(arr1[index]>p1 && arr2[index]>p2)
        {
            ans = solve(arr1,arr2,index+1,0,dp);
        }
        if(arr1[index]>p2 && arr2[index]>p1)
        {
            ans = Math.min(1+solve(arr1,arr2,index+1,1,dp),ans);
        }
        return dp[index][swap] = ans;
    }
}