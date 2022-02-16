class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int arr[] = new int[1000001];
        for(int i=0;i<intervals.length;i++)
        {
            fill(arr,intervals[i][0],intervals[i][1]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            ans = Math.max(ans,arr[i]);
        }
        return ans;
    }
    public void fill(int arr[],int start,int end)
    {
        for(int i=start;i<end;i++)
        {
            arr[i]++;
        }
    }
}