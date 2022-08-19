class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> last = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) 
        {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        for (int x : nums) 
        {
           // 1 2 3 3 4 5
            // 1 4 2 3
            
            if(freq.get(x)!=0)
            {
                
            if (last.getOrDefault(x-1,0)>0) 
            {
                last.put(x-1,last.getOrDefault(x-1,0)-1);
                last.put(x, last.getOrDefault(x, 0) + 1);
            } 
            else if (freq.getOrDefault(x+1,0)>0 && freq.getOrDefault(x+2,0)>0) 
            {
                last.put(x+2,last.getOrDefault(x+2,0)+1);
                freq.put(x+1,freq.getOrDefault(x+1,0)-1);
                freq.put(x+2,freq.getOrDefault(x+2,0)-1);
            } 
            else 
            {
                return false;
            }
            freq.put(x,freq.get(x)-1);
            }
        }
        return true;
    }
}