class Solution {
    int n;
    int m;
    int[][]grid;
    Integer[][][][]dp;
    public int cherryPickup(int[][] g) {
        n=g.length;
        m=g[0].length;
        grid=g;
        dp=new Integer[50][50][50][50];
        return Math.max(0,helper(0,0,0,0));
    }public int helper(int r1,int c1,int r2,int c2){
        if(r1>=n||c1>=m||r2>=n||c2>=m||grid[r1][c1]==-1||grid[r2][c2]==-1)return Integer.MIN_VALUE;
        int ans=grid[r1][c1];
        if(r1==n-1&&c1==m-1)return grid[r1][c1];
        if(dp[r1][c1][r2][c2]!=null)return dp[r1][c1][r2][c2];
        if(c1!=c2)ans+=grid[r2][c2];
        int temp=Math.max(
            helper(r1+1,c1,r2+1,c2),
            Math.max(helper(r1,c1+1,r2,c2+1),
            Math.max(helper(r1+1,c1,r2,c2+1),
            helper(r1,c1+1,r2+1,c2)))
        );
        ans+=temp;
        return dp[r1][c1][r2][c2]=ans;
    }
}