class Solution {
    Integer[][]dp;
    public int change(int a, int[] coins) {
        dp=new Integer[coins.length][a+1];
        return helper(coins,a,0);
    }public int helper(int[]coins,int a,int idx){
        if(a==0)return 1;
        if(idx==coins.length||a<0)return 0;
        if(dp[idx][a]!=null)return dp[idx][a];
        int ntake=helper(coins,a,idx+1);
        int take=helper(coins,a-coins[idx],idx);
        return dp[idx][a]= ntake+take;
    }
}