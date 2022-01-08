class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int arr[] = new int[60];
        for(int i=0;i<time.length;i++)
        {
            arr[time[i]%60]++;
        }
        int ans = 0;
        for(int i=0;i<=30;i++)
        {
            if(i == 0 || i == 30)
            {
                int n = arr[i];
                ans = ans + (n*(n-1))/2;
            }
            else
            {
                ans = ans + arr[i]*arr[60-i];
            }
        }
        return ans;
    }
}