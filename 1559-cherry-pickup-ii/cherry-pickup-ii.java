class Solution {
    int n;
    int m;
    int[][]grid;
    Integer[][][]dp;
    public int cherryPickup(int[][] g) {
        n=g.length;
        m=g[0].length;
        grid=g;
        dp=new Integer[n+1][m+1][m+1];
        return helper(0,0,m-1);
    }public int helper(int r1,int c1,int c2){
        if (c1<0 ||c1>= m||c2 < 0||c2>= m) return Integer.MIN_VALUE;
        if (r1 == n-1){
            if (c1==c2) return grid[r1][c1];
            return grid[r1][c1]+grid[r1][c2];
        }
        if(dp[r1][c1][c2]!=null)return dp[r1][c1][c2];
        int ans = grid[r1][c1];
        if (c1!=c2) ans+=grid[r1][c2];
        int temp=0;
        for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
                temp=Math.max(temp,helper(r1+1,c1+d1,c2+d2));
            }
        }
        ans+=temp;
        return dp[r1][c1][c2]=ans;
    }
}