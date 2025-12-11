class Solution {
    public boolean canPartition(int[] nums) {

        int sum =0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%2!=0)return false;
        int target = sum/2;
        Boolean[][]dp= new Boolean[nums.length][target+1];
        return helper(target,nums,0,dp);
    }
    public boolean helper(int target,int[]nums,int idx,Boolean[][]dp){
        if(target<0)return false;
        if(target==0)return true;
        if(idx>=nums.length)return false;
        if(dp[idx][target]!=null){
            if(dp[idx][target]==false){
                return false;
            }else{
                return true;
            }
        }
        boolean res=helper(target-nums[idx],nums,idx+1,dp)||helper(target,nums,idx+1,dp);
        if(res){
            dp[idx][target]=true;
        }else{
            dp[idx][target]=false;
        }
        return res;
        
    }
}
