class Solution {
    int[]nums;
    Map<String,Integer>dp=new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        this.nums=nums;
        // dp=new Integer[nums.length+1][target+1];
        return helper(0,target,0);
    }public int helper(int idx,int target,int sum){
        if(idx==nums.length)return target==sum?1:0;
        String key=idx+","+sum;
        if(dp.containsKey(key))return dp.get(key);
        int take1=helper(idx+1,target,sum+nums[idx]);
        int take2=helper(idx+1,target,sum-nums[idx]);
        dp.put(key,take1+take2);
        return take1+take2;
    }
}