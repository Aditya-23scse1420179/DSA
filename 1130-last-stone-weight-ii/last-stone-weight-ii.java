class Solution {
    public int helper(int[] stones,int sum,int currSum,int idx,Integer[][]dp){
        if(idx==stones.length)return Integer.MAX_VALUE;
        if(dp[idx][sum]!=null)return dp[idx][sum];
        int take = helper(stones,sum-stones[idx],currSum+stones[idx],idx+1,dp);
        int Nottake = helper(stones,sum,currSum,idx+1,dp);
        return dp[idx][sum]= Math.min(Math.abs(currSum-sum),Math.min(take,Nottake));
    }
    public int lastStoneWeightII(int stones[]) {
        int sum =0;
        for(int i : stones)sum+=i;
        Integer dp[][]= new Integer[stones.length][sum+1];
        return helper(stones,sum,0,0,dp);
    }
}