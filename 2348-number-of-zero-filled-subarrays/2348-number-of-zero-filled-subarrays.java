class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int ans = 0;
        int p = 0;
        long finans = 0;
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == 0)
            {
                nums[i] = ++p;
            }
            else
            {
                nums[i] = 0;
                p=0;
            }
            finans += nums[i];
            System.out.println(nums[i]);
        }
        return finans;
    }
}