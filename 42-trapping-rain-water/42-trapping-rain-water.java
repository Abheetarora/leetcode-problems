class Solution {
    public int trap(int[] height) {
        //find the max left and max right from a particular positiom
        int maxL[] = new int[height.length];
        int maxR[] = new int[height.length];
        int n = height.length;
        maxL[0] = height[0];
        for(int i = 1;i<n;i++)
        {
            maxL[i] = Math.max(maxL[i-1],height[i]);
        }
        maxR[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            maxR[i] = Math.max(maxR[i+1],height[i]);
        }
        int ans = 0;
       
        for(int i=0;i<n;i++)
        {
            ans = ans + Math.min(maxR[i] , maxL[i]) - height[i];
        }
        return ans;
    }
}