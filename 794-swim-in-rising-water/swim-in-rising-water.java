class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static class pair{
        int row,col,dist;
        public pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][]dist=new int[n][m];
        for(int []a:dist){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        PriorityQueue<pair>q=new PriorityQueue<>((a,b)->a.dist-b.dist);
        q.offer(new pair(0,0,grid[0][0]));
        dist[0][0]=grid[0][0];
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            int d=curr.dist;
            if(dist[r][c]<d)continue;
            if(r==n-1&&c==m-1)return d;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr<0||nr>=n||nc<0||nc>=m)continue;
                int dis=Math.max(d,grid[nr][nc]);
                if(dis<dist[nr][nc]){
                    dist[nr][nc]=dis;
                    q.offer(new pair(nr,nc,dis));
                }
            }
        }
        return -1;

    }
}