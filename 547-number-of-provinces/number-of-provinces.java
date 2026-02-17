class Solution {
    int[]parent;
    int []size;
    public int findCircleNum(int[][] edges) {
        int n=edges.length;
        parent=new int[edges.length];
        size=new int[edges.length];
        for(int i=0;i<edges.length;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<edges[0].length;j++){
                if(edges[i][j]==1){
                    unionsize(i,j);
                }
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i)count++;
        } 
        return count;
        
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public boolean unionsize(int x,int y){
        int p_x=find(x);
        int p_y=find(y);

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