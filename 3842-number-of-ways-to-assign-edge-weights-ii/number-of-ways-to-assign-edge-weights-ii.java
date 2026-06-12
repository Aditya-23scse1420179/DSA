class Solution {
    int LOG = 17;
    int MOD = 1_000_000_007;
    int[][] up;
    int[] depth;
    List<Integer>[] adj;
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        up = new int[LOG][n + 1];
        depth = new int[n + 1];
        dfs(1, -1);
        for (int i = 1; i < LOG; i++) {
            for (int node = 1; node <= n; node++) {
                if (up[i - 1][node] != -1) {
                    up[i][node] = up[i - 1][up[i - 1][node]];
                } else {
                    up[i][node] = -1;
                }
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (u == v) {
                ans[i] = 0;
                continue;
            }
            int lca = getLCA(u, v);
            int dist = depth[u] + depth[v] - 2 * depth[lca];
            ans[i] = power(2, dist - 1);
        }
        return ans;
    }
    public void dfs(int node, int parent) {
        up[0][node] = parent;
        for (int child : adj[node]) {
            if (child == parent) continue;
            depth[child] = depth[node] + 1;
            dfs(child, node);
        }
    }
    int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int diff = depth[u] - depth[v];
        for (int i = 0; i < LOG; i++) {
            if ((diff & (1 << i)) != 0) {
                u = up[i][u];
            }
        }
        if (u == v) return u;
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[i][u] != up[i][v]) {
                u = up[i][u];
                v = up[i][v];
            }
        }
        return up[0][u];
    }
    public int power(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return (int) ans;
    }
}