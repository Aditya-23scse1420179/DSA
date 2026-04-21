class Solution {
    Integer[][]dp;
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int a:stones)sum+=a;
        dp=new Integer[stones.length][sum+1];
        return helper(0,sum,0,stones);
    }public int helper(int idx,int sum,int currsum,int[]stones){
        if(idx==stones.length)return (int)1e9;
        if(dp[idx][sum]!=null)return dp[idx][sum];
        int take=helper(idx+1,sum-stones[idx],currsum+stones[idx],stones);
        int ntake=helper(idx+1,sum,currsum,stones);
        return dp[idx][sum]=Math.min(Math.abs(sum-currsum),Math.min(take,ntake));
    }
}