class Solution {
    int min=Integer.MAX_VALUE;
    int n,m;
    int[][]grid;
    Boolean[][][]dp;
    public int minCost(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        this.grid=grid;
        dp=new Boolean[n][m][1024];
        helper(0,0,grid[0][0]);
        return min;
    }
    public void helper(int r,int c,int curr){
        if(r==n-1&&c==m-1){
            min=Math.min(min,curr);
            return ;
        }
        if(dp[r][c][curr]!=null)return ;
        dp[r][c][curr]=true;
        if(c+1<m){
            helper(r,c+1,curr^grid[r][c+1]);
        }
        if(r+1<n){
            helper(r+1,c,curr^grid[r+1][c]);
        }

    }
}