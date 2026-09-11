class Solution {
    HashMap<String,Integer>map=new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0,nums,target,0);
    }public int helper(int idx,int[]nums,int target,int sum){
        if(idx>=nums.length){
            return sum==target?1:0;
        }
        String key=idx+" "+sum;
        if(map.containsKey(key))return map.get(key);
        int t1=helper(idx+1,nums,target,sum+nums[idx]);
        int t2=helper(idx+1,nums,target,sum-nums[idx]);
        map.put(key,t1+t2);
        return t1+t2;
    }
}