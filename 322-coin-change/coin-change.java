class Solution {
    public int coinChange(int[] arr, int amount) {
        int n = arr.length;
        int INF = (int)1e9;
        int[][] dp =new int[n+1][amount + 1];
        for (int s = 1; s <= amount; s++) {
            dp[0][s]=INF;
        }
        dp[0][0]=0;
        for (int i =1;i<= n;i++) {
            for (int s= 0;s <=amount;s++) {
                int notTake = dp[i-1][s];
                int take = (int)(1e9);
                if (s >= arr[i-1]){
                    take =1 +dp[i][s-arr[i-1]];
                }
                dp[i][s] =Math.min(take,notTake);
            }
        }
        return dp[n][amount]>=(int)1e9?-1 :dp[n][amount];
    }
}
