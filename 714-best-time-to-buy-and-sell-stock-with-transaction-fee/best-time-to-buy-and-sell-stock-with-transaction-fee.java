class Solution {
    Integer[][]dp;
    public int maxProfit(int[] prices, int fee) {
        dp=new Integer[2][prices.length];
        return helper(prices,fee,1,0);
    }public int helper(int[]prices,int fee,int take,int i){
        if(i==prices.length)return 0;
        if(dp[take][i]!=null)return dp[take][i];
        if(take==1){
            return dp[take][i]= Math.max(-prices[i]+helper(prices,fee,0,i+1),
            helper(prices,fee,1,i+1));
        }else{
            return dp[take][i]= Math.max(prices[i]-fee+helper(prices,fee,1,i+1),
            helper(prices,fee,0,i+1));
        }
    }
}