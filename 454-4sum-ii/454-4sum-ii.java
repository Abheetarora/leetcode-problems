class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
       Map<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                if(map.containsKey(nums1[i] + nums2[j]) == true)
                {
                    map.put(nums1[i] + nums2[j],map.get(nums1[i] + nums2[j])+1);
                }
                else
                {
                    map.put(nums1[i] + nums2[j],1);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<nums3.length;i++)
        {
            for(int j=0;j<nums4.length;j++)
            {
                if(map.containsKey(-(nums3[i] + nums4[j])))
                {
                  ans = ans + map.get(-(nums3[i] + nums4[j]));
                    //map.put(nums1[i] + nums2[j],map.get(nums1[i] + nums2[j])+1);
                }
            }
        }
        return ans;
    }
}