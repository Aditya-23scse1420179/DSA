class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        Integer[][] dp = new Integer[n][n];

        // ✅ Base case: last row copy
        for (int j = 0; j < n; j++) {
            dp[n-1][j] = t.get(n-1).get(j);
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = dp[i+1][j];
                int diag = dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag) + t.get(i).get(j);
            }
        }

        return dp[0][0];
    }
}
