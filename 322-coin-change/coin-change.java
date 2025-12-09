class Solution {
    public int helper(int []coins,int idx,int amount,Integer[][]dp){
        if(amount==0)return 0;
        if(idx==coins.length)return (int)1e9;
        if(amount<0)return (int)1e9;
        if(dp[idx][amount]!=null)return dp[idx][amount];
        int take = 1+helper(coins,idx,amount-coins[idx],dp);
        int nottake=helper(coins,idx+1,amount,dp);
        dp[idx][amount]= Math.min(take,nottake);
        return dp[idx][amount];
    }
    public int coinChange(int[] coins, int amount) {
        Integer[][]dp=new Integer[coins.length][amount+1];
        int ans=helper(coins,0,amount,dp);
        return ans>= (int)1e9 ? -1 :ans;
    }
}