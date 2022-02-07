class Solution {
    public int wiggleMaxLength(int[] nums) {
        return ans(nums);
    }
    public  int solve(int[] arr, int s, int cb,int dp[][])
    {
        if(s>=arr.length)
        {
            return 0;
        }
        if(dp[s][cb] == 0)
        {
        int result = 0;
        
        for (int i = s; i < arr.length; i++)
        {
            // include kra - > next element bda
            if (cb == 1 && arr[i - 1] < arr[i]) {
                result = Math.max(result, 1 + solve(arr, i + 1, 0,dp));
            }
            // include kra - > next element chota
            else if (cb == 0 && arr[i - 1] > arr[i]) {
                result = Math.max(result, 1 + solve(arr, i + 1, 1,dp));
            }
            // include hi nahi kra - > maa chuda element
            else {
                result = Math.max(result, solve(arr, i + 1, cb,dp));
            }
        }
        dp[s][cb] = result;
        }
 
        return dp[s][cb];
    }
    public int ans(int[] nums)
    {
        if(nums.length == 0)
        {
            return 0;
        }
        int dp[][] = new int[nums.length][2];
        // do condition - > agla chota ya agla bda
        return 1+(Math.max( solve(nums,1,0,dp) , solve(nums,1,1,dp)) );
    }
}