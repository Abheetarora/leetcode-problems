class Solution {
    static Integer getmax(HashMap<Integer,Integer> map){
        int max = Integer.MIN_VALUE;
        Integer result = null;
        for(int key: map.keySet()){
            if(max<map.get(key)){ 
                
                max = map.get(key);
                result = key;
            }
        }
        return result;
    }
    public int minimumOperations(int[] nums) {
        if(nums.length ==1|| nums.length ==0) return 0;
        HashMap<Integer,Integer> oddmap = new HashMap<>();
        HashMap<Integer,Integer> evenmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                if(evenmap.containsKey(nums[i])) evenmap.put(nums[i],evenmap.get(nums[i])+1);
                else evenmap.put(nums[i],1);
            }
            else{
                if(oddmap.containsKey(nums[i])) oddmap.put(nums[i],oddmap.get(nums[i])+1);
                else oddmap.put(nums[i],1);
            }
        }
        int oddMaxKey = getmax(oddmap);
        int evenMaxKey = getmax(evenmap);
        while(oddMaxKey==evenMaxKey){
            if(oddmap.get(oddMaxKey)>=evenmap.get(evenMaxKey)){ 
                if(evenmap.size()==1&&oddmap.size()==1) return nums.length/2;
                 else if(evenmap.size()==1) {
                     oddmap.remove(oddMaxKey);
                     oddMaxKey = getmax(oddmap);
                }
                else{
                    evenmap.remove(evenMaxKey);
                    evenMaxKey = getmax(evenmap);
                }
            }
            else{
                if(oddmap.size()==1&&evenmap.size()==1) return nums.length/2;
                 else if(oddmap.size()==1) {
                     evenmap.remove(evenMaxKey);
                     evenMaxKey = getmax(evenmap);
                }
                else{
                oddmap.remove(oddMaxKey);
                oddMaxKey = getmax(oddmap);
                }
            }
        }
        int result = nums.length - oddmap.get(oddMaxKey) - evenmap.get(evenMaxKey);
        return result;
    }
}