class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int count = 0, curr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int n : nums){
            curr += n;
            if(map.containsKey(curr - k)){
                count += map.get(curr - k);
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return count;
    }
}
