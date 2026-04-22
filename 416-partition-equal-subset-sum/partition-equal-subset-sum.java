class Solution {
    Boolean[][]dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        
        if(sum%2!=0)return false;
        int target=sum/2;
        dp=new Boolean[nums.length][target+1];
        return helper(0,target,nums);
    }public boolean helper(int idx,int target,int[]nums){
        if(target<0)return false;
        if(target==0)return true;
        if(idx==nums.length)return false;
        if(dp[idx][target]!=null)return dp[idx][target];
        boolean take=helper(idx+1,target-nums[idx],nums);
        boolean ntake=helper(idx+1,target,nums);
        return dp[idx][target]=take||ntake;
    }
}