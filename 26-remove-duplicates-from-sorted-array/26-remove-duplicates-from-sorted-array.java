class Solution {
    public int removeDuplicates(int[] nums) {
        int change = 1,count = 1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == nums[i-1])
            {
                count++;
            }
            else
            {
                count = 1;
            }
            if(count < 2)
            {
                nums[change++] = nums[i];
            }
        }
        return change;
    }
}