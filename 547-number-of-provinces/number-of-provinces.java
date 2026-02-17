class Solution {
    int[]parent;
    int[]rank;
    public int findCircleNum(int[][]connect) {
        int n=connect.length;
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        rank=new int[n];
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                if(connect[i][j]==1){
                    unionrank(i,j);
                }
            }
        }int count=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i)count++;
        }
        return count;        
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public boolean unionrank(int x,int y){
        int p_x=find(x);
        int p_y=find(y);
        if(p_x==p_y)return false;//cycle
        if(rank[p_x]>rank[p_y]){
            parent[p_y]=p_x;
        }else if(rank[p_y]>rank[p_x]){
            parent[p_x]=p_y;
        }else{
            parent[p_x]=p_y;
            rank[p_x]++;
        }
        return true;
    }
}