class Solution {
    int n,m;
    Integer[][]dp;
    public int minFallingPathSum(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        dp=new Integer[n][m];
        int max=(int)1e9;
        for(int i=0;i<m;i++){
            max=Math.min(max,helper(0,i,matrix));
        }
        return max;
    }public int helper(int r,int c,int[][]matrix){
        if(r>=n||c>=m||c<0)return (int)1e9;
        if(r==n-1)return matrix[r][c];
        if(dp[r][c]!=null)return dp[r][c];
        int d=helper(r+1,c,matrix);
        int dl=helper(r+1,c-1,matrix);
        int dr=helper(r+1,c+1,matrix);
        return dp[r][c]=Math.min(d,Math.min(dl,dr))+matrix[r][c];
    }
}