class Solution {
    Long[][]dp;
    public long maxAlternatingSum(int[] nums) {
        dp=new Long[nums.length][3];
        return helper(0,nums,0);
    }public long helper(int idx,int[]nums,int odd){
        if(idx>=nums.length)return 0;
        if(dp[idx][odd]!=null)return dp[idx][odd];
        long pick;
        if(odd==0){
            pick=nums[idx]+helper(idx+1,nums,1);
        }else{
            pick=-nums[idx]+helper(idx+1,nums,0);
        }
        long skip=helper(idx+1,nums,odd);
        return dp[idx][odd]=Math.max(pick,skip);
    }
}