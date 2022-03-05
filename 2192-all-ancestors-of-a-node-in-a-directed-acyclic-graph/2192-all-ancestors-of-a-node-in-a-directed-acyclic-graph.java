class Solution {
    List<Integer> [] graph;
    boolean [] visited;
    List<Integer> [] result;
    
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        graph = new List[n];
        visited = new boolean[n];
        result = new List[n];
        
        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();
        
        for (int [] edge : edges){
            graph[edge[1]].add(edge[0]);
            visited[edge[0]] = true;
        }
        
        for (int i = 0; i < n; ++i){
            if (visited[i]) continue;
            
            result[i] = getList(i);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for (List<Integer> list : result){
            ans.add(list);
            Collections.sort(list);
        }
        
        return ans;
    }
    
    private List<Integer> getList(int node){
        if (result[node] != null)
            return result[node];
        
        Set<Integer> set = new HashSet<>();
        
        for (int child : graph[node]){
            set.add(child);
            set.addAll(getList(child));
        }
        
        result[node] = new ArrayList<>(set);
        return result[node];
    }
}