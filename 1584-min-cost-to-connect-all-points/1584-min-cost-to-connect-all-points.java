class Pair{
int index;
int val;
public Pair(int index,int val){
    this.index=index;
    this.val=val;
}
}

class Solution {
public int minCostConnectPoints(int[][] points) {
    LinkedList<Pair>[] adj = new LinkedList[points.length];
    for(int i=0;i<points.length;i++){
        adj[i]=new LinkedList();
    }
    for(int i=0;i<points.length-1;i++){
        int[] first = points[i];
        for(int j=i+1;j<points.length;j++){
            int[] second = points[j];            
            adj[i].add(new Pair(j,((Math.abs(first[0]-second[0]))+(Math.abs(first[1]-second[1])))));
            adj[j].add(new Pair(i,((Math.abs(first[0]-second[0]))+(Math.abs(first[1]-second[1])))));
        }
    }
    PriorityQueue<Pair> Q = new PriorityQueue<>((a,b)->{
        return a.val-b.val;
    });
    Q.add(new Pair(0,0));
    int ans=0;
    boolean[] tracker = new boolean[points.length+1];
    for(int i=0;i<points.length;i++){
        while(tracker[Q.peek().index]){
            Q.poll();
        }
        Pair temp = Q.poll();
        int index = temp.index;
        tracker[index]=true;
        ans+=temp.val;
        Iterator<Pair> k = adj[index].listIterator();
        while(k.hasNext()){
            Pair n = k.next();
            if(!tracker[n.index]){
                Q.add(n);
            }
        }
        
        
    }
    return ans;
    
    
}
}