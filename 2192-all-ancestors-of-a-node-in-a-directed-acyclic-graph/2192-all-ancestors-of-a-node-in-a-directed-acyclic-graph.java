class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
    List<List<Integer>> ans = new ArrayList();
    List<List<Integer>> directChild = new ArrayList();
    for (int i = 0; i < n; i++) {
        ans.add(new ArrayList());
        directChild.add(new ArrayList());
    }
    for (int[] e: edges) 
        directChild.get(e[0]).add(e[1]);
    for (int i = 0; i < n; i++) {
        Set<Integer> visited = new HashSet();
        dfs(i, i, visited, ans, directChild);
    }
    return ans;
}
private void dfs(int x, int curr, Set<Integer> visited, List<List<Integer>> ans, List<List<Integer>> directChild) {
    visited.add(curr);
    for (int ch: directChild.get(curr)) {
        if(!visited.contains(ch)) {
            ans.get(ch).add(x);
            dfs(x, ch, visited, ans, directChild);
        }
    }
}
}