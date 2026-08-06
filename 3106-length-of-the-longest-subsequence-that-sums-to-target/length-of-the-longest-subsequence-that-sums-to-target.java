class Solution {
    // HashMap<String,Integer>dp=new HashMap<>();
    Integer[][]dp;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        dp=new Integer[nums.size()][target+1];
        return helper(0,nums,target)<0?-1:helper(0,nums,target);
    }public int helper(int idx,List<Integer>nums,int target){
        if(target==0)return 0;
        if(idx>=nums.size()||target<0)return -(int)1e9;
        // String key=idx+","+target;
        // if(dp.containsKey(key))return dp.get(key);
        if(dp[idx][target]!=null)return dp[idx][target];
        int ntake=helper(idx+1,nums,target);
        int take=1+helper(idx+1,nums,target-nums.get(idx));
        return dp[idx][target]=Math.max(ntake,take);
        // dp.put(key,ans);
        
        // return ans;
    }
}