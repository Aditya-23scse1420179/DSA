/*class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp=new int[m][n];
        for(int []row:dp)Arrays.fill(row,-1); 
        return helper(0,0,m,n,dp);
    }
    public static int helper(int i,int j,int m,int n,int[][]dp){
        if(i==m-1||j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int right=helper(i,j+1,m,n,dp);
        int down = helper(i+1,j,m,n,dp);
        return dp[i][j]=right+down;
    }
}*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = m -2;i >=0;i--) {
            for (int j = n- 2;j >= 0;j--) {
                dp[i][j]= dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[0][0];
    }
}
