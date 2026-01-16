class Solution {
    public int change(int amount, int[] coins) {
        int[][]dp=new int[coins.length+1][amount+1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                int ntake=dp[i-1][j];
                int take=0;
                if(coins[i-1]<=j){
                    take=dp[i][j-coins[i-1]];
                }
                dp[i][j]=ntake+take;
            }
        }
        return dp[coins.length][amount];
    }
}