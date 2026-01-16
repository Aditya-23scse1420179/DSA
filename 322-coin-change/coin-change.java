class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][]dp=new Integer[coins.length+1][amount+1];
        int ans= helper(0,amount,coins,dp);
        return ans>=100000+7?-1:ans;
    }public static int helper(int i,int amount,int[] coins,Integer[][]dp){
        if(i==coins.length)return (int)1e9;
        if(amount<0)return (int)1e9;
        if(amount==0)return 0;
        if(dp[i][amount]!=null)return dp[i][amount];
        int take=1+helper(i+1,amount-coins[i],coins,dp);
        int take1=1+helper(i,amount-coins[i],coins,dp);
        int ntake=helper(i+1,amount,coins,dp);
        return dp[i][amount]=Math.min(take,Math.min(take1,ntake));
    }
}