class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int arr[] = new int[n];
        int nums[] = new int[n];
        int prev = 100005;
        for(int i =0;i<n;i++)
        {
            if(seats[i] == 1)
            {
                prev = 0;
                arr[i] = 0;
            }
            if(seats[i] == 0)
            {
                prev++;
                arr[i] = prev;
            }
        }
        prev =  100005;
        for(int i=n-1;i>=0;i--)
        {
            if(seats[i] == 1)
            {
                prev = 0;
                nums[i] = 0;
            }
             if(seats[i] == 0)
            {
                prev++;
                nums[i] = prev;
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            arr[i] = Math.min(arr[i],nums[i]);
            ans = Math.max(ans,arr[i]);
        }
        return ans;
        
    }
}