class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n-1;i>=0;i--){
            dp[i][1] = Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);          // buy or skip
            dp[i][0] = Math.max(prices[i]+dp[i+1][1]-fee,dp[i+1][0]);     // sell (pay fee) or skip
        }
        return dp[0][1];
    }
}