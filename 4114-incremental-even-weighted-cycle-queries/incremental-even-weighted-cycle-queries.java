class Solution {
    int []parent;
    int[]rank;
    int[]parity;
    public int numberOfEdgesAdded(int n, int[][] edges) {
        parent=new int[n];
        rank=new int[n];
        parity=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }int add=0;
        for(int []a:edges){
            int u=a[0];
            int v=a[1];
            int w=a[2];

            int ux=find(u);
            int uy=find(v);
            if(ux==uy){
                if((parity[u]^parity[v]^w)==0)add++;
            }
            else {
                unionrank(v,u,w);
                add++;
            }
        }
        return add;
    }public int find(int x){
        if(parent[x]!=x){
            int p=parent[x];
            parent[x]=find(parent[x]);
            parity[x]=parity[x]^parity[p];
        }
        return parent[x];
    }public void unionrank(int x,int y,int w){
        int px=find(x);
        int py=find(y);
        if(rank[px]>rank[py]){
            parent[py]=px;
            parity[py]=parity[x]^parity[y]^w;
        }else if(rank[py]>rank[px]){
            parent[px]=py;
            parity[px]=parity[x]^parity[y]^w;
        }else{
            parent[px]=py;
            rank[py]++;
            parity[px]=parity[x]^parity[y]^w;
        }
    }
}