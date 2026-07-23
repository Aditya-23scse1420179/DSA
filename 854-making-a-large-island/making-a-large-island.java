class Solution {//tc:O(n*m),sc:O(n*m)
    int[]parent,size;
    int n,m;
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    public int largestIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        parent=new int[n*m];
        size=new int[n*m];
        for(int i=0;i<n*m;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int gn=(i*m)+j;
                if(grid[i][j]==1){
                    for(int d=0;d<4;d++){
                        int nr=i+dr[d];
                        int nc=j+dc[d];
                        if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==1){
                            int gm=(nr*m)+nc;
                            unionsize(gn,gm);
                        }
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    Set<Integer>set=new HashSet<>();
                    for(int d=0;d<4;d++){
                        int nr=i+dr[d];
                        int nc=j+dc[d];
                        if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==1){
                            set.add(find(nr*m + nc));
                        }
                    }int ans=1;
                    for(int a:set){
                        ans+=size[a];
                    
                    }
                    max=Math.max(ans,max);
                }
            }
        }
        return max==0?n*m:max;
    }public int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }public boolean unionsize(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py)return false;

        if(size[px]>size[py]){
            parent[py]=px;
            size[px]+=size[py];
        }else{
            parent[px]=py;
            size[py]+=size[px];
        }
        return true;
    }
}