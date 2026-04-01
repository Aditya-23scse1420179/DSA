class Solution {
    int[] parent;
    int[] rank;
    int find(int x){
        while(parent[x]!=x){
            x = parent[parent[x]];
        }
        return x;
    }
    void makeUnion(int x, int y){
        int parX = find(x);
        int parY = find(y);
        if(parX == parY){
            return;
        }
        else if(rank[parX]<rank[parY]){
            parent[parX] = parY;
        }
        else if(rank[parX]>rank[parY]){
            parent[parY] = parX;
        }
        else{
            parent[parY] = parX;
            rank[parX]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(edges<n-1){
            return -1;
        }
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        for(int[] con : connections){
            makeUnion(con[0], con[1]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            int par = find(i);
            set.add(par);
        }
        int unions = set.size();
        return unions-1;
    }
}