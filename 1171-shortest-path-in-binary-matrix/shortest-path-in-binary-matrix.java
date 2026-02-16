class Solution {
    static int[]dr={-1,1,0,0,-1,-1,1,1};
    static int[]dc={0,0,-1,1,-1,1,-1,1};
    static class pair{
        int row;
        int col;
        int dist;
        public pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][]dist=new int[n][m];
        for(int[]a:dist){
            Arrays.fill(a,(int)1e9);
        }
        dist[0][0]=1;
        Queue<pair>q=new LinkedList<>();
        if(grid[0][0]==1)return -1;
        q.offer(new pair(0,0,1));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            int w=curr.dist;
            for(int i=0;i<8;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr<0||nr>=n||nc<0||nc>=m)continue;
                if(grid[nr][nc]==0){
                    if(dist[nr][nc]>w+1){
                        dist[nr][nc]=w+1;
                        q.offer(new pair(nr,nc,dist[nr][nc]));
                    }else 
                        continue;
                }
            }
        }
        return dist[n-1][m-1]<(int)1e9?dist[n-1][m-1]:-1;
    }
}