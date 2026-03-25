class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    class pair{
        int row,col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;
        int[][]dist=new int[n][m];
        boolean[][]visit=new boolean[n][m];
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1&&!visit[i][j]){
                    q.offer(new pair(i,j));
                    visit[i][j]=true;
                    dist[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&isWater[nr][nc]==0&&!visit[nr][nc]){
                    dist[nr][nc]=dist[r][c]+1;
                    visit[nr][nc]=true;
                    q.offer(new pair(nr,nc));
                }
            }
        }
        return dist;
    }
}