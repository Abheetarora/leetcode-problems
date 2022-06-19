class Solution {
    public int[][] merge(int[][] nums) {
         Comparator<int[]> comp = new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        };
        
        // sort on the basis of starting point
        Arrays.sort(nums, comp);
       
       int start=nums[0][0];
        int end=nums[0][1];
         ArrayList<int[]> ans = new ArrayList<>();
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i][0]>end)
            {
               ans.add(new int[]{start,end}) ;
                   start=nums[i][0];
                end=nums[i][1];
            }
            else if(nums[i][1]>=end)
            {
                end=nums[i][1];
            }
        }
        ans.add(new int[]{start,end}) ;
        System.out.println(ans.size());
        return ans.toArray(new int[ans.size()][]);
        
    }
}