class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum[] = new int[queries.length];
        int esum = 0;
        for(int i=0;i<nums.length;i++)
        {
            //if(nums[i]%2==0)
            if((nums[i]&1)==0)
            {
                esum += nums[i];
            }
        }
        for(int i=0;i<queries.length;i++)
        {
            // already even  - coming even
            if(nums[queries[i][1]]%2==0 && queries[i][0]%2==0)
            {
                esum += queries[i][0];
            }
            // already odd - coming even
            if(nums[queries[i][1]]%2!=0 && queries[i][0]%2==0)
            {
                
            }
            //already odd -  coming odd
             if(nums[queries[i][1]]%2!=0 && queries[i][0]%2!=0)
            {
                esum += queries[i][0] + nums[queries[i][1]];
            }
            //already even - comming odd
             if(nums[queries[i][1]]%2==0 && queries[i][0]%2!=0)
            {
                esum -= nums[queries[i][1]];
            }
            nums[queries[i][1]] += queries[i][0];
            sum[i] = esum;
        }
        return sum;
    }
}

// 