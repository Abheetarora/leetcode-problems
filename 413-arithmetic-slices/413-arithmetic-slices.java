class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int k =0;
        int ans = 0;
       
       for(int i=2;i<nums.length;i++)
       {
           
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])
           {
              // System.out.println(k);
               k++;
           }
           else
           {
             ans += ((k+1)*(k))/2;
               k =0;
           }
       }
         ans += ((k+1)*(k))/2;
        return ans;
        
    }
}