class Solution {
    public int coinChange(int[] arr, int amount) {
        int n = arr.length;
        int INF = (int)1e9;
        int[][] dp =new int[n][amount + 1];
        for (int s = 0; s <= amount; s++) {
            if (s % arr[0] ==0)
                dp[0][s] = s/arr[0];   
            else
                dp[0][s] =(int)1e9;       
        }
        for (int i =1;i< n;i++) {
            for (int s= 0;s <=amount;s++) {
                int notTake = dp[i-1][s];
                int take = (int)(1e9);
                if (s >= arr[i]){
                    take =1 +dp[i][s-arr[i]];
                }
                dp[i][s] =Math.min(take,notTake);
            }
        }
        return dp[n-1][amount] >= (int)1e9?-1 :dp[n-1][amount];
    }
}
