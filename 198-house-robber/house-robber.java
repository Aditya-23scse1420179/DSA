class Solution {
    public int rob(int[] nums) {
        int n =nums.length;
        if (n ==0) return 0;
        int[] memo = new int[n];
        Arrays.fill(memo,-1);       
        return helper(nums,0, memo);
    }
    public int helper(int[] nums,int i,int[] memo) {
        if (i >=nums.length) return 0;
        if (memo[i]!= -1) return memo[i];   
        int rob =nums[i] + helper(nums,i+2, memo); 
        int skip= helper(nums, i +1,memo);         
        memo[i] =Math.max(rob,skip);
        return memo[i];
    }
}