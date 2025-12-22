class Solution {
    public int helper(int []nums,int curr,int prev,Integer dp[][]){
        if(curr==nums.length)return 0;
        if(dp[curr][prev+1]!=null)return dp[curr][prev+1];
        int notTake = helper(nums,curr+1,prev,dp);
        int take=0;
        if(prev==-1|| nums[curr]>nums[prev]){
            take =1+ helper(nums,curr+1,curr,dp);
        }
        return dp[curr][prev+1]=Math.max(notTake,take);
    }
    public int lengthOfLIS(int[] nums) {
        Integer dp[][]=new Integer[nums.length][nums.length+1];
        return helper(nums,0,-1,dp);
    }
}