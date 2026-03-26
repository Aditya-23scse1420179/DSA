class Solution {
    Integer[]dp;
    public int jump(int[] nums) {
        dp=new Integer[nums.length];
        int ans=helper(0,nums);
        return ans==Integer.MAX_VALUE?-1:ans;
    }public int helper(int idx,int[]nums){
        if(idx>=nums.length-1)return 0;
        if(dp[idx]!=null)return dp[idx];
        if(nums[idx]==0)return Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=nums[idx]&&idx+i<=nums.length-1;i++){
           int next = helper(idx + i, nums);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + next);
            }
        }
        return dp[idx]=min;
    }
}