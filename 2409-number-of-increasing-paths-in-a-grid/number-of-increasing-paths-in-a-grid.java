class Solution {
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    int n,m;
    Integer[][]dp;
    public int countPaths(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        dp=new Integer[n][m];
        long ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=(ans+dfs(grid,i,j))%1000000007;
            }
        }
        return (int)ans;
    }public int dfs(int[][]grid,int r,int c){
        if(dp[r][c]!=null)return dp[r][c];
        long ans=1;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]>grid[r][c]){
                ans=(ans+dfs(grid,nr,nc))%1000000007;
            }
        }
        return dp[r][c]=(int)ans;
    }
}