class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int [][]dp=new int [m][n];
        for(int[] row:dp) Arrays.fill(row,-1);
        return helper(dungeon,0,0,dp);
    }
    public int helper (int[][]dungeon,int r,int c,int[][]dp){
        int m=dungeon.length;
        int n=dungeon[0].length;
        if(r>=m||c>=n)return Integer.MAX_VALUE;
        if (r == m -1 &&c ==n -1 ) {
            if ((dungeon[r][c])<= 0)
                return Math.abs(dungeon[r][c]) + 1;
            else
                return 1;
        }
        if(dp[r][c]!=-1)return dp[r][c];
        int right=helper(dungeon,r,c+1,dp);
        int down= helper(dungeon,r+1,c,dp);
        int need= Math.min(right,down)-dungeon[r][c];
        return dp[r][c]=need<=0?1:need;
    }
}