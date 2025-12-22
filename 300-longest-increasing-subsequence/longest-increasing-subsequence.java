class Solution {
    public int helper(int []nums,int idx,int prev,Integer dp[][]){
        if(idx==nums.length)return 0;
        if(dp[idx][prev+1]!=null)return dp[idx][prev+1];
        int notTake = helper(nums,idx+1,prev,dp);
        int take=0;
        if(prev==-1|| nums[idx]>nums[prev]){
            take =1+ helper(nums,idx+1,idx,dp);
        }
        return dp[idx][prev+1]=Math.max(notTake,take);
    }
    public int lengthOfLIS(int[] nums) {
        Integer dp[][]=new Integer[nums.length][nums.length+1];
        return helper(nums,0,-1,dp);
    }
}