class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int arr[] = new int[mat.length];
        for(int i=0;i<mat.length;i++)
        {
            int count = 0;
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j] == 1)
                {
                    count++;
                }
            }
            arr[i] = count;
        }
        PriorityQueue<pair> pq = new PriorityQueue<pair>(k, new pairComparator());
    
        for(int i=0;i<arr.length;i++)
        {
            pq.add(new pair(i,arr[i]));
        }
    int i =0;
        int ret[]=new int[k];
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
        if(a.frq!=b.frq)
        return a.frq - b.frq;
        else
        {
            return a.num - b.num;
        }
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