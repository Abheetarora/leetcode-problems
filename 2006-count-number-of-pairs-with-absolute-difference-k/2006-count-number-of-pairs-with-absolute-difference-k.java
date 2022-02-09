class Solution {
    public int countKDifference(int[] nums, int k) {
        return findPairs(nums,k);
    }
        public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
             int prev = 0;

            if (map.get(nums[i]) != null) {
                prev = map.get(nums[i]);
            }
 
            map.put(nums[i], prev + 1);
        }
        int counter =0 ;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]+k) && k>0)
            {
                counter= counter +  map.get(nums[i]+k);
                
            }
            else
            {
                if(k==0)
                {
                    if(map.get(nums[i])!=null && map.get(nums[i])>1 )
                    {
                        counter++;
                        //map.remove(nums[i]);
                    }
                }
            }
            
        }
        return counter;
        
    }
    }
