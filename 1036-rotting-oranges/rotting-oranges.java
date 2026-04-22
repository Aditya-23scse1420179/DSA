class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static class pair{
        int r,c,t;
        public pair(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
    int max=0;
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        Queue<pair>q=new LinkedList<>();
        boolean[][]visit=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new pair(i,j,0));
                    visit[i][j]=true;
                }else if(grid[i][j]==1)fresh++;
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                pair curr=q.poll();
                int row=curr.r;
                int col=curr.c;
                int ti=curr.t;
                max=Math.max(max,ti);
                for(int i=0;i<4;i++){
                    int nr=row+dr[i];
                    int nc=col+dc[i];
                    if(nr<0||nr>=n||nc<0||nc>=m)continue;
                    if(grid[nr][nc]==1&&!visit[nr][nc]){
                        fresh--;
                        visit[nr][nc]=true;
                        q.offer(new pair(nr,nc,ti+1));
                    }
                }
            }
        }
        return fresh==0?max:-1;

    }
}