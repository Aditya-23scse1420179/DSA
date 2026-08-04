class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        return helper(0,nums,target,1,1,false,false);
    }public boolean helper(int idx,int[]nums,long target,long A,long B,boolean au,Boolean bu){
        if(idx==nums.length)return au&&bu&&A==target&&B==target;
        if(helper(idx+1,nums,target,A*nums[idx],B,true,bu))return true;
        if(helper(idx+1,nums,target,A,B*nums[idx],au,true))return true;
        return false;
    }
}