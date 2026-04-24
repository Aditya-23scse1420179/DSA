class Solution {
    Integer[]dp;
    public int minCostClimbingStairs(int[] cost) {
        dp=new Integer[cost.length];
        return Math.min(helper(cost,0),helper(cost,1));
    }public int helper(int[]cost,int idx){
        if(idx>=cost.length)return 0;
        if(dp[idx]!=null)return dp[idx];
        int take1=cost[idx]+helper(cost,idx+1);
        int take2=cost[idx]+helper(cost,idx+2);
        return dp[idx]=Math.min(take1,take2);
    }
}