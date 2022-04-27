class Solution {
   static List<Integer>[] adj = new ArrayList[100000];

static void dfs(int vertex, String s, boolean[] visit, List<Integer> ind, List<Character> ch) {

    ch.add(s.charAt(vertex));
    ind.add(vertex);
    visit[vertex] = true;

    for (int cur : adj[vertex]) {
        if (!visit[cur]) {
            dfs(cur, s, visit, ind, ch);
        }
    }
}

static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    int n = s.length();

    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }

    for (List<Integer> edge : pairs) {
        adj[edge.get(0)].add(edge.get(1));
        adj[edge.get(1)].add(edge.get(0));
    }

    char[] res = new char[n];

    boolean[] visit = new boolean[n];

    for (int i = 0; i < n; i++) {
        if (!visit[i]) {
            List<Character> ch = new ArrayList<>();
            List<Integer> ind = new ArrayList<>();

            dfs(i, s, visit, ind, ch);

            Collections.sort(ch);
            Collections.sort(ind);

            for (int j = 0; j < ch.size(); j++) {
                res[ind.get(j)] = ch.get(j);
            }
        }
    }
    return new String(res);
}
}