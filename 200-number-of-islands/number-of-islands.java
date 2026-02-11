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
    public int numIslands(char[][] grid) {
        rl=grid.length;
        cl=grid[0].length;
        boolean[][]visit=new boolean[rl][cl];
        int component=0;
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(grid[i][j]=='1'&&!visit[i][j]){
                    dfs(i,j,visit,grid);
                    component++;
                }
            }
        }
        return component;
    }public void dfs(int r,int c,boolean[][]visit,char[][]grid){
        if(r<0||c<0||r>=rl||c>=cl||visit[r][c]||grid[r][c]=='0')return ;
        visit[r][c]=true;
        for(int k=0;k<4;k++){
            dfs(r+dr[k],c+dc[k],visit,grid);
        }
    }
}