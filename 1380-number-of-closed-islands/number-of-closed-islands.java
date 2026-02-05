class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,1,-1};
    static int rl;
    static int cl;
    public int closedIsland(int[][] grid) {
        rl=grid.length;
        cl=grid[0].length;
        boolean[][]visit=new boolean[rl][cl];
        for(int i=0;i<rl;i++){
            if(grid[i][0]==0)dfs(i,0,grid,visit);
            if(grid[i][cl-1]==0)dfs(i,cl-1,grid,visit);
        }for(int j=0;j<cl;j++){
            if(grid[0][j]==0)dfs(0,j,grid,visit);
            if(grid[rl-1][j]==0)dfs(rl-1,j,grid,visit);
        }int count=0;
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(grid[i][j]==0&&!visit[i][j]){
                    dfs(i,j,grid,visit);
                    count++;
                }
            }
        }
        return count;
    }public void dfs(int r,int c,int[][]grid,boolean[][]visit){
        if(r<0||c<0||r>=rl||c>=cl||grid[r][c]==1)return;
        if(visit[r][c]==true)return;
        visit[r][c]=true;
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],grid,visit);
        }
    }
}