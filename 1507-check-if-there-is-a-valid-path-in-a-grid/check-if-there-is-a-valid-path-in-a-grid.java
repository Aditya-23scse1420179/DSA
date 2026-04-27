class Solution {
    int n;
    int m;
    static int[][][]dir={
        {},
        {{0,-1},{0,+1}},
        {{-1,0},{+1,0}},
        {{0,-1},{+1,0}},
        {{0,+1},{+1,0}},
        {{0,-1},{-1,0}},
        {{0,+1},{-1,0}},
    };
    boolean[][]visit;
    public boolean hasValidPath(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        visit=new boolean[n][m];
        return dfs(grid,0,0);
    }public boolean dfs(int[][]grid,int r,int c){
        if(r==n-1&&c==m-1)return true;
        visit[r][c]=true;
        for(int []a:dir[grid[r][c]]){
            int nr=r+a[0];
            int nc=c+a[1];
            if(nr<0||nr>=n||nc<0||nc>=m||visit[nr][nc])continue;
            for(int[]x:dir[grid[nr][nc]]){
                if(nr+x[0]==r&&nc+x[1]==c){
                    if(dfs(grid,nr,nc))return true;
                }
                
            }
        }
        return false;
    }
}