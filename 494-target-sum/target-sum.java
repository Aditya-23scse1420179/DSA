class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        helper(0,nums,target,0);
        return count;
    }public void helper(int idx,int[]nums,int target,int sum){
        if(idx==nums.length){
            if(sum==target){
                count++;
            }
            return;
        }
        helper(idx+1,nums,target,sum+nums[idx]);
        helper(idx+1,nums,target,sum-nums[idx]);
    }
}