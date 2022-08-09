class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(mp.get(nums[i])==null)
            {
                mp.put(nums[i],i);
            }
            else
            {
                
            }
        }
        int ans[] = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(mp.containsKey(target-nums[i]) && mp.get(target - nums[i])!=i)
            {
                return new int[]{i,mp.get(target-nums[i])};
            }
        }
      return null;  
    }
}