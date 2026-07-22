class Solution {
    Long[][]dp;
    public long maxAlternatingSum(int[] nums) {
        dp=new Long[nums.length+1][2];
        return helper(nums,0,0);
    }public long helper(int[]nums,int idx,int isodd){
        if(idx>=nums.length)return 0;
        if(dp[idx][isodd]!=null)return dp[idx][isodd];
        long pick;
        if(isodd==0){
            pick=nums[idx]+helper(nums,idx+1,1);
        }else{
            pick=-nums[idx]+helper(nums,idx+1,0);
        }
        long skip=helper(nums,idx+1,isodd);
        return dp[idx][isodd]=Math.max(pick,skip);
    }
}