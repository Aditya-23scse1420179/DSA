class Solution {
    int[]parent;
    int[]rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent=new int[edges.length+1];
        for(int i=0;i<=edges.length;i++){
            parent[i]=i;
        }
        rank=new int[edges.length+1];
        int[]ans=new int[2];
        for(int i=0;i<edges.length;i++){
            if(!unionrank(edges[i][0],edges[i][1])){
                ans[0]=edges[i][0];
                ans[1]=edges[i][1];
            }
        }
        return ans;
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public boolean unionrank(int x,int y){
        int p_x=find(parent[x]);
        int p_y=find(parent[y]);
        if(p_x==p_y)return false;
        if(rank[p_x]>rank[p_y]){
            parent[p_y]=p_x;
        }else if(parent[p_x]<parent[p_y]){
            parent[p_x]=p_y;
        }else{
            parent[p_x]=p_y;
            rank[p_y]++;
        }
        return true;
    }
}