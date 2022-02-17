class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<pair>pq = new PriorityQueue<>(k, new pairComparator());
        for(int i=0;i<points.length;i++)
        {
            int distance = calculate(points[i][0],points[i][1]);
            pq.add( new pair( i,distance ) );
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        
        int ans[][] = new int[k][2];
        int i=0;
        while(pq.size()>0)
        {
            pair point = pq.peek();
            ans[i][0] = points[point.num][0];
            ans[i][1] = points[point.num][1];
            pq.poll();
            i++;
        }
        return ans;
        
    }
    public int calculate(int x,int y)
    {
        return ( (x*x) + (y*y) );
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