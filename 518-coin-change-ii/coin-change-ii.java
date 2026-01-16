class Solution {
    public int change(int amount, int[] coins) {
        Integer[][]dp=new Integer[coins.length+1][amount+1];
        return helper(0,amount,coins,dp);
    }public static int helper(int i,int amount,int[]coins,Integer[][]dp){
        if(i==coins.length||amount<0)return 0;
        if(amount==0)return 1;
        if(dp[i][amount]!=null)return dp[i][amount];
        int ntake=helper(i+1,amount,coins,dp);
        int take=helper(i,amount-coins[i],coins,dp);
        return dp[i][amount]=take+ntake;
    }
}