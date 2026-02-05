class Solution {
    static int[]dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int rl;
    static int cl;
    public int numEnclaves(int[][] grid) {
        rl=grid.length;
        cl=grid[0].length;
        boolean[][]visit=new boolean[rl][cl];
        for(int i=0;i<rl;i++){
            if(grid[i][0]==1)dfs(i,0,grid,visit);
            if(grid[i][cl-1]==1)dfs(i,cl-1,grid,visit);
        }for(int j=0;j<cl;j++){
            if(grid[0][j]==1)dfs(0,j,grid,visit);
            if(grid[rl-1][j]==1)dfs(rl-1,j,grid,visit);
        }int count=0;
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(grid[i][j]==1&&!visit[i][j]){
                    count++;
                }
            }
        }
        return count;
    }public void dfs(int r,int c,int[][]grid,boolean[][]visit){
        if(r<0||c<0||r>=rl||c>=cl||grid[r][c]==0)return;
        if(visit[r][c]==true)return;
        visit[r][c]=true;
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],grid,visit);
        }
    }
}