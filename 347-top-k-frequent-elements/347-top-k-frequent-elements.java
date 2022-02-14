class Solution {
public int[] topKFrequent(int[] nums, int k) {
int[] ret = new int[k];
Map<Integer, pair> map = new HashMap<Integer, pair>();

    for(int i = 0; i< nums.length; i++){
        if(map.containsKey(nums[i])){
            pair ct = map.get(nums[i]);
            ct.frq += 1;
            
        }else{
            map.put(nums[i], new pair(nums[i], 1));
        }
    }
    
    PriorityQueue<pair> pq = new PriorityQueue<pair>(k, new pairComparator());
    for(Map.Entry<Integer, pair> e : map.entrySet()){
        pq.add(e.getValue());
    }
    int i =0;
    while(!pq.isEmpty()){
        pair p = pq.poll();
        if(i<k){
             ret[i++] = p.num; 
        }else{
            break;
        }
      
    }
    return ret;
}
}
class pairComparator implements Comparator<pair> {
    public int compare(pair a, pair b)
    {
 
        return b.frq - a.frq;
    }
}
 
class pair{
int num;
int frq;
pair(int num, int frq){
this.num = num;
this.frq = frq;
}
}