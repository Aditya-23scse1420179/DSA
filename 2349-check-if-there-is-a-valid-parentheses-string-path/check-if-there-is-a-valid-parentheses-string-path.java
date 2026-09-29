class Solution {
    Boolean dp[][][];
    int n,m;
    public boolean hasValidPath(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        dp=new Boolean[n+1][m+1][200];
        return helper(0,0,0,grid);
    }public boolean helper(int r,int c,int count,char[][]grid){
        if(grid[r][c]=='(')count++;
        else count--;
        if(count<0)return false;
        if(r==n-1&&c==m-1)return count==0;
        if(dp[r][c][count]!=null)return dp[r][c][count];
        boolean right=false;
        if(c+1<m)right=helper(r,c+1,count,grid);
        boolean left=false;
        if(r+1<n)left=helper(r+1,c,count,grid);
        return dp[r][c][count]=right||left;
    }
}