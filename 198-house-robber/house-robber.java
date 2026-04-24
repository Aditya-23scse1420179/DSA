class Solution {
    Integer[]dp;
    public int rob(int[] nums) {
        dp=new Integer[nums.length+1];
        return helper(nums,0);
    }public int helper(int[]nums,int idx){
        if(idx>=nums.length)return 0;
        if(dp[idx]!=null)return dp[idx];
        int ntake=helper(nums,idx+1);
        int take=helper(nums,idx+2)+nums[idx];
        return dp[idx]=Math.max(take,ntake);
    }
}