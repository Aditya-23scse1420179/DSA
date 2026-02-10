class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int m;
    static int n;
    class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int shortestBridge(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        boolean[][]visit=new boolean[n][m];
        Queue<pair>q=new LinkedList<>();
        boolean found =false;
        for(int i=0;i<n;i++){
            if(found)break;
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(i,j,visit,grid,q);
                    found=true;
                    break;
                }
            }
        }int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                pair curr=q.remove();
                int r=curr.row;
                int c=curr.col;
                for(int i=0;i<4;i++){
                    int nr=r+dr[i];
                    int nc=c+dc[i];
                    if(nr<0||nc<0||nr>=n||nc>=m||visit[nr][nc])continue;
                    if(grid[nr][nc]==1)return level;
                    visit[nr][nc]=true;
                    q.offer(new pair(nr,nc));
                }
            }level++;

        }
        return level;
    }public void dfs(int r,int c,boolean[][]visit,int[][]grid,Queue<pair>q){
        if(r<0||c<0||r>=n||c>=m||visit[r][c]||grid[r][c]==0)return;
        visit[r][c]=true;
        q.offer(new pair(r,c));
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            dfs(nr,nc,visit,grid,q);
        }

    }
}