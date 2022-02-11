class Solution {
 public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        int max = nums[0];
        for(int a: nums) {
            if(a > max) max = a;  // Compute max
            set.add(a);    // Deduplicate
        }
        if(set.size() < 3) return max;
        for(int a: set) {
            pq.add(a);
            if(pq.size() > 3) pq.poll();
        }
        return pq.peek();
	}
}