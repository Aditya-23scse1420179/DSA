class Solution {
    public static int helper(int[][] grid, int sr, int sc, int er, int ec,int[][]dp) {
        if (sr > er || sc > ec) return Integer.MAX_VALUE;
        if (sr == er && sc == ec) return grid[sr][sc];
        if(dp[sr][sc]!=-1)return dp[sr][sc];
        int right = helper(grid, sr, sc + 1, er, ec,dp);
        int down  = helper(grid, sr + 1, sc, er, ec,dp);
        return dp[sr][sc]=grid[sr][sc] + Math.min(right, down);
    }
    public int minPathSum(int[][] grid) {
        int [][]dp=new int[grid.length][grid[0].length];
        for(int[] row:dp)Arrays.fill(row,-1);
        int er = grid.length - 1;
        int ec = grid[0].length - 1;
        return helper(grid, 0, 0, er, ec,dp);
    }
}
