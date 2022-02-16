class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++)
        {
            pq.add(stones[i]);
        }
        int first = 0;
        while(pq.size()>1)
        {
             first = pq.poll();
            int second = pq.poll();
            System.out.println(first + " " + second);
            if(first == second)
            {
                
            }
            else
            {
                pq.add(Math.abs(second-first));
            }
        }
        if(pq.size()==0)
        {
            return 0;
        }
        return pq.peek();
    }
}