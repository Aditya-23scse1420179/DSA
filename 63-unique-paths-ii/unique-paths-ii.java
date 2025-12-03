class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n= obstacleGrid[0].length;
        int [][]dp= new int [m][n];
        for(int[]rows:dp) Arrays.fill(rows,-1);
        return helper(obstacleGrid,m,n,0,0,dp);
    }
    public static int helper(int[][]obstacleGrid,int m,int n,int i,int j,int[][]dp){
        if(i>=m||j>=n||obstacleGrid[i][j]==1){
            return 0;
        }
        if(i==m-1&&j==n-1)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        int down= helper(obstacleGrid,m,n,i+1,j,dp);
        int right=helper(obstacleGrid,m,n,i,j+1,dp);
        return dp[i][j]=(down+right);
    }
}