class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int rl;
    static int cl;
    boolean[][]visit;
    class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int shortestBridge(int[][] grid) {
        rl=grid.length;
        cl=grid[0].length;
        boolean found =false;
        visit=new boolean[rl][cl];
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<rl;i++){
            if(found)break;
            for(int j=0;j<cl;j++){
                if(grid[i][j]==1){
                    dfs(i,j,q,grid);
                    found=true;
                    break;
                }
            }
        }int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                pair curr=q.poll();
                int r=curr.row;
                int c=curr.col;
                for(int i=0;i<4;i++){
                    int nrow=r+dr[i];
                    int ncol=c+dc[i];
                    if(nrow<0||ncol<0||nrow>=rl||ncol>=cl||visit[nrow][ncol])continue;
                    if(grid[nrow][ncol]==1)return level;
                    visit[nrow][ncol]=true;
                    q.offer(new pair(nrow,ncol));
                }
            }
            level++;
        }
        return-1;
    }public void dfs(int r,int c,Queue<pair>q,int[][]grid){
        if(r<0||c<0||r>=rl||c>=cl||visit[r][c]==true||grid[r][c]==0)return;
        visit[r][c]=true;
        q.offer(new pair(r,c));
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],q,grid);
        }
    }
}