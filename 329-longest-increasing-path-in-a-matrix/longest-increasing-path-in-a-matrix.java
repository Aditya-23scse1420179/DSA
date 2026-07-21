class Solution {
    int []dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    int n,m;
    Integer[][]dp;
    public int longestIncreasingPath(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        dp=new Integer[n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max=Math.max(max,dfs(i,j,matrix));
            }
        }
        return max;
    }
    public int dfs(int r,int c,int[][]matrix){
        if(dp[r][c]!=null)return dp[r][c];
        int cmax=1;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&matrix[nr][nc]>matrix[r][c]){
                cmax=Math.max(cmax,1+dfs(nr,nc,matrix));
            }
        }
        return dp[r][c]=cmax;
    }
}