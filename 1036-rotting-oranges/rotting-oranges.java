class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int rowL;
    static int colL;
    int maxt=0;
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
    public int orangesRotting(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][]visit=new boolean[rowL][colL];
        int fresh=0;
        Queue<pair>q=new LinkedList<>();
        //add all rotten oranges
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]==2){//2 represnt rotten orange
                    visit[i][j]=true;
                    q.offer(new pair(i,j,0));
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
            maxt=Math.max(maxt,t);
            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];
                if(nrow>=0&&ncol>=0&&nrow<rowL&&ncol<colL&&grid[nrow][ncol]==1&&!visit[nrow][ncol]){
                    visit[nrow][ncol]=true;
                    fresh--;
                    q.offer(new pair(nrow,ncol,t+1));
                }
            }
        }
        return(fresh==0)?maxt:-1;

    }
}