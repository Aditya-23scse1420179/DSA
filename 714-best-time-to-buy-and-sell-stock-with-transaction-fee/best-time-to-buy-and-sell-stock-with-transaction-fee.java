class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] row : dp) Arrays.fill(row, -1);

        return findMax(dp, prices, 0, 1, fee);
    }

    private int findMax(int[][] dp, int[] prices, int i, int canBuy, int fee) {
        if (i == prices.length) return 0;

        if (dp[i][canBuy] != -1) return dp[i][canBuy];

        if (canBuy == 1) {
            return dp[i][canBuy] = Math.max(
                -prices[i] + findMax(dp, prices, i + 1, 0, fee),   // buy
                findMax(dp, prices, i + 1, 1, fee)                   // skip
            );
        } else {
            return dp[i][canBuy] = Math.max(
                prices[i] - fee + findMax(dp, prices, i + 1, 1, fee),  // sell (pay fee)
                findMax(dp, prices, i + 1, 0, fee)                       // skip
            );
        }
    }
}