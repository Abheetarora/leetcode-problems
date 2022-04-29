class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] color = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]) continue; // if node is already traversed
            
            if(!dfs(i,false,visited,color,graph)) return false; // if graph coloring fails.
        }
        return true;
    }
    static boolean dfs(int node,boolean c,boolean[] visited,boolean[] color,int[][] graph){
        visited[node]=true;
        color[node]=c;
        for(int child:graph[node]){
            if(!visited[child] && !dfs(child,!c,visited,color,graph)) return false; // if graph coloring fails for child node
            if(color[node]==color[child]) return false; // condition for failure of graph coloring
        }
        return true;
    }
}