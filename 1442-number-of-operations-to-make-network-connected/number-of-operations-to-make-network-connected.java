class Solution {
    int[] par;

    public int find(int x) {
        if(par[x] == x) return x;
        par[x] = find(par[x]);
        return par[x];
    }

    public void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);
        if(parX != parY) {
            par[parY] = parX;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        par = new int[n];
        for(int i=0;i<n;i++) par[i] = i;
        if(connections.length < n-1) return -1;
        for(int[] conn:connections) {
            union(conn[0], conn[1]);
        }
        int rem = 0;
        for(int i=0;i<n;i++) {
            if(par[i] == i) rem++;
        }
        return rem-1;
    }
}