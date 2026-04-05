class Solution {
    Integer[][]dp;
    public int uniquePaths(int m, int n) {
        dp=new Integer[n+1][m+1];
        return helper(m,n,0,0);
    }public int helper(int m,int n,int r,int c){
        if(r==n-1||c==m-1)return 1;
        if(dp[r][c]!=null)return dp[r][c];
        int right=helper(m,n,r+1,c);
        int left=helper(m,n,r,c+1);
        return dp[r][c]=left+right;
    }
}
