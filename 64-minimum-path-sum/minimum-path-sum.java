class Solution {
    int n;
    int m;
    Integer[][]dp;
    public int minPathSum(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        dp=new Integer[n+1][m+1];
        return helper(grid,0,0);
    }public int helper(int[][]grid,int i,int j){
        if(i==n-1&&j==m-1)return grid[i][j];
        if(i>=n||j>=m)return (int)1e9;
        if(dp[i][j]!=null)return dp[i][j];
        int down=helper(grid,i+1,j);
        int right=helper(grid,i,j+1);
        return dp[i][j]=grid[i][j]+Math.min(down,right);
    }
}