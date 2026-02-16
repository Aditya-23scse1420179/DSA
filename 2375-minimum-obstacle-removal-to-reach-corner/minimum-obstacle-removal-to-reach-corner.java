class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    public class pair{
        int row;
        int col;
        int dist;
        public pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][]dist=new int[n][m];
        for(int []a:dist){
            Arrays.fill(a,(int)1e9);
        }
        dist[0][0]=0;
        Queue<pair>q=new LinkedList<>();
        q.offer(new pair(0,0,0));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            int w=curr.dist;
            if(w>dist[r][c])continue;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr<0||nr>=n||nc<0||nc>=m)continue;
                if(dist[nr][nc]>w+grid[nr][nc]){
                    dist[nr][nc]=w+grid[nr][nc];
                    q.offer(new pair(nr,nc,dist[nr][nc]));
                }
            }
        }
        return dist[n-1][m-1];
    }
}