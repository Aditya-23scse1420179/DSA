class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    class pair{
        int row;
        int col;
        int pos;
        int step;
        public pair(int row,int col,int pos,int step){
            this.row=row;
            this.col=col;
            this.pos=pos;
            this.step=step;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int [][]dist=new int[n][m];
        if(k>=n+m-2)return n+m-2;
        for(int []a:dist){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        Queue<pair>q=new LinkedList<>();
        q.offer(new pair(0,0,0,0));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            int np=curr.pos;
            int s=curr.step;
            if(r==n-1&&c==m-1)return s;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr<0||nr>=n||nc<0||nc>=m)continue;
                int nk=np+grid[nr][nc];
                if(k<nk)continue;
                if(dist[nr][nc]<=nk)continue;
                dist[nr][nc]=nk;
                q.offer(new pair(nr,nc,nk,s+1));
            }
        }
        return -1;
    }
}