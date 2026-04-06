class Solution {
    int n;
    int m;
    int[][]grid;
    Integer[][][]dp;
    public int cherryPickup(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        this.grid=grid;
        dp=new Integer[n][m][m];
        return helper(0,0,m-1);
    }public int helper(int r,int c1,int c2){
        if(c1<0||c1>=m||c2<0||c2>=m)return Integer.MIN_VALUE;
        if(r==n-1){
            if(c1==c2)return grid[r][c1];
            return grid[r][c1]+grid[r][c2];
        }
        if(dp[r][c1][c2]!=null)return dp[r][c1][c2];
        int ans=grid[r][c1];
        if(c1!=c2)ans+=grid[r][c2];
        int temp=0;
        for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
                temp=Math.max(temp,helper(r+1,c1+d1,c2+d2));
            }
        }
        ans+=temp;
        return dp[r][c1][c2]=ans;
    }
}