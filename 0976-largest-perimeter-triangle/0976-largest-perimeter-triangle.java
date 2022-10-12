class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-2;i++)
        {
        int a = nums[i+0];
        int b =nums[i+1];
        int c = nums[i+2];
        if(a+b>c && b+c>a && c+a>b)
        {
            mx = Math.max(mx,a+b+c);
        }
        
    }
        if(mx == Integer.MIN_VALUE)
        {
            return 0;
        }
        else
        {
            return mx;
        }
}
}