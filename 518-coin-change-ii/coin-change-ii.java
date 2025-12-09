class Solution {
    public int helper(int amount ,int[]coins,int idx,Integer[][]dp){
        if(idx==coins.length)return 0;
        if(amount<0)return 0;
        if(amount==0)return 1;
        if(dp[idx][amount]!=null)return dp[idx][amount];
        int take=helper(amount-coins[idx],coins,idx,dp);
        int nottake=helper(amount,coins,idx+1,dp);
        dp[idx][amount]=take+nottake;
        return dp[idx][amount];
    }
    public int change(int amount, int[] coins) {
        Integer[][]dp=new Integer[coins.length][amount+1];
        return helper(amount,coins,0,dp);
    }
}