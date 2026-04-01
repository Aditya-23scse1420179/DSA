class Solution {
    int[]parent;
    int[]rank;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int comp=n;
        for(int[]a:connections){
            int u=a[0];
            int v=a[1];
            if(unionrank(u,v))comp--;
        }
        return comp-1;
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public boolean unionrank(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py)return false;
        if(rank[px]>rank[py]){
            parent[py]=px;
        }else if(rank[py]>rank[px]){
            parent[px]=py;
        }else{
            parent[px]=py;
            rank[py]++;
        }
        return true;
    }
}