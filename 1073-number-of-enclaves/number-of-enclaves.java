class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int rl;
    static int cl;
    static class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        } 
    }
    public int numEnclaves(int[][] grid) {
        rl=grid.length;
        cl=grid[0].length;
        boolean[][]visit=new boolean[rl][cl];
        for(int i=0;i<rl;i++){
            if(grid[i][0]==1)bfs(i,0,visit,grid);
            if(grid[i][cl-1]==1)bfs(i,cl-1,visit,grid);
        }for(int j=0;j<cl;j++){
            if(grid[0][j]==1)bfs(0,j,visit,grid);
            if(grid[rl-1][j]==1)bfs(rl-1,j,visit,grid);
        }int count=0;
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(grid[i][j]==1&&!visit[i][j]){
                    count++;
                }
            }
        }
        return count;
    }public void bfs(int r,int c,boolean[][]visit,int [][]grid){
        Queue<pair>q=new LinkedList<>();
        visit[r][c]=true;
        q.offer(new pair(r,c));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r1=curr.row;
            int c1=curr.col;
            for(int i=0;i<4;i++){
                int nrow=r1+dr[i];
                int ncol=c1+dc[i];
                if(nrow>=0&&ncol>=0&&nrow<rl&&ncol<cl&&!visit[nrow][ncol]&&grid[nrow][ncol]==1){
                    visit[nrow][ncol]=true;
                    q.offer(new pair(nrow,ncol));

                }
            }
        }
    }
}