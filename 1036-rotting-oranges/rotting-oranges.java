class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int rl;
    static int cl;
    class pair{
        int row;
        int col;
        int time;
        public pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    int maxt=0;
    public int orangesRotting(int[][] grid) {
        rl=grid.length;
        cl=grid[0].length;
        int fresh=0;
        boolean[][]visit=new boolean[rl][cl];
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(grid[i][j]==2){
                    q.offer(new pair(i,j,0));
                    visit[i][j]=true;
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }if(fresh==0)return 0;
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            int t=curr.time;
            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];
                maxt=Math.max(maxt,t);
                if(nrow>=0&&ncol>=0&&nrow<rl&&ncol<cl&&grid[nrow][ncol]==1&&!visit[nrow][ncol]){
                    visit[nrow][ncol]=true;
                    fresh--;
                    q.offer(new pair(nrow,ncol,t+1));
                }
            }
        }
        return(fresh==0)?maxt:-1;
    }
}