class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if(nums.length==1)return nums[0];
        int[]arr=new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            arr[i]=nums[i];
        }
        int[]ar=new int[nums.length-1];
        int id=0;
        for(int i=1;i<nums.length;i++){
            ar[id++]=nums[i];
        }
        Integer[]dp1=new Integer[arr.length];
        Integer[]dp2=new Integer[ar.length];
        return Math.max(helper(0,arr,dp1),helper(0,ar,dp2));
    }public int helper(int idx,int[]nums,Integer[]dp){
        if(idx>=nums.length)return 0;
        if(dp[idx]!=null)return dp[idx];
        int take=nums[idx]+helper(idx+2,nums,dp);
        int take2=helper(idx+1,nums,dp);
        return dp[idx]=Math.max(take,take2);
    }
}