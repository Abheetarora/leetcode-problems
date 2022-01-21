class Solution {
    public int findMiddleIndex(int[] nums) {
        return pivotIndex(nums);
    }
    public int pivotIndex(int[] nums) {
        int sum = 0,sum2 = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum = sum + nums[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            if(sum2 == sum-sum2-nums[i])
            {
                return i;
            }
            sum2 += nums[i];
        }
        return -1;
    }
}