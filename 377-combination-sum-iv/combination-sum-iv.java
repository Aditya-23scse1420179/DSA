class Solution {
    int n;
    Integer[]dp;
    public int combinationSum4(int[] nums, int target) {
        n=nums.length;
        dp=new Integer[target+1];
        return helper(nums,target);
    }public int helper(int[]nums,int target){
        if(target==0)return 1;
        if(target<0)return 0;
        if(dp[target]!=null)return dp[target];
        int pick=0;
        for(int i=0;i<n;i++){
            pick+=helper(nums,target-nums[i]);
        }
        return dp[target]=pick;
    }
}