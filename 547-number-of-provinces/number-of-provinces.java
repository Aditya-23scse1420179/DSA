class Solution {
    int []parent;
    int []rank;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1)union(i,j);
            }
        }
        int comp=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i)comp++;
        }
        return comp;
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public boolean union(int x,int y){
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