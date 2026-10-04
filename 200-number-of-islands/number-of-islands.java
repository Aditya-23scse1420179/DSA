class Solution {
    int rl,cl;
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    boolean[][]visit;
    public int numIslands(char[][] grid) {
        rl=grid.length;
        cl=grid[0].length;
        visit=new boolean[rl][cl];
        int count=0;
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(grid[i][j]=='1'&&!visit[i][j]){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }public void dfs(int r,int c,char[][]grid){
        if(r<0||c<0||r>=rl||c>=cl||grid[r][c]=='0'||visit[r][c])return;
        visit[r][c]=true;
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],grid);
        }
    }
}