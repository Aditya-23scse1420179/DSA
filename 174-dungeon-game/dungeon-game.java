class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(0, 0, dungeon, dp);
    }
    public int solve(int i, int j, int[][] dungeon , int[][] dp) {
        int m =dungeon.length;
        int n = dungeon[0].length;
        if (i >= m ||j >= n)
            return Integer.MAX_VALUE;
        if (i == m -1 &&j ==n -1 ) {
            if ((dungeon[i][j])<= 0)
                return Math.abs(dungeon[i][j]) + 1;
            else
                return 1;
        }
        if (dp[i][j]!= -1)
            return dp[i][j];
        int right = solve(i, j + 1, dungeon, dp);
        int down = solve(i + 1, j, dungeon, dp);
        int need = Math.min(right, down) - dungeon[i][j];
        return dp[i][j] = need <= 0 ? 1 : need;

    }
}