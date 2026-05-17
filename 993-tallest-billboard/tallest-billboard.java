class Solution {
    Integer[][] dp;
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        dp = new Integer[n][10001];
        return helper(0, 0, rods);
    }
    public int helper(int idx, int diff, int[] rods) {
        if(idx == rods.length) {
            if(diff == 0) return 0;

            return -(int)1e9;
        }
        if(dp[idx][diff] != null)
            return dp[idx][diff];
        int skip = helper(idx + 1, diff, rods);
        int taller =
            helper(idx + 1,
                   diff + rods[idx],
                   rods);
        int smaller =
            Math.min(diff, rods[idx]) +
            helper(idx + 1,
                   Math.abs(diff - rods[idx]),
                   rods);
        return dp[idx][diff] =
            Math.max(skip,
            Math.max(taller, smaller));
    }
}