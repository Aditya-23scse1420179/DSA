class Solution {
    int[]parent;
    int []rank;
    public int removeStones(int[][] stones) {
        int n=stones.length;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }int comp=n;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0]||
                stones[i][1]==stones[j][1]){
                    if(unionrank(i,j)){
                        comp--;
                    }
                }
            }
        }
        return n-comp;
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public boolean unionrank(int x,int y){
        int p_x=find(x);
        int p_y=find(y);
        if(p_x==p_y)return false;
        if(rank[p_x]>rank[p_y]){
            parent[p_y]=p_x;
        }else if(rank[p_y]>rank[p_x]){
            parent[p_x]=p_y;
        }else{
            parent[p_x]=p_y;
            rank[p_y]++;
        }
        return true;
    }    
}