class Solution {
    int[]parent;
    int[]size;
    public int removeStones(int[][] stones) {
        int n=stones.length;
        parent=new int[n+1];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0]||
                stones[i][1]==stones[j][1]){
                    unionsize(i,j);
                }
            }
        }int comp=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                comp++;
            }
        }
        return n-comp;
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public boolean unionsize(int x,int y){
        int p_x=find(x);
        int p_y=find(y);
        if(p_x==p_y)return false;//cycle
        if(size[p_x]>size[p_y]){
            parent[p_y]=p_x;
        }else if(size[p_y]>size[p_x]){
            parent[p_x]=p_y;
            size[p_y]+=size[p_x];
        }else{
            parent[p_x]=p_y;
            size[p_y]+=size[p_x];
        }
        return true;
    }
}