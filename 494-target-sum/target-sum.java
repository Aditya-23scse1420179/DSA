class Solution {
    Integer[][]dp;
    public int findTargetSumWays(int[] nums, int target) {
        dp=new Integer[nums.length+1][2021];
        return helper(nums, target, 0, 0);
    }
    private int helper(int[] arr, int target, int idx, int sum) {
        if (idx >= arr.length)
            return sum == target ? 1 : 0;
        if(dp[idx][sum+1010]!=null)return dp[idx][sum+1010];
        int subtract = helper(arr, target, idx + 1, sum - arr[idx]);
        int add = helper(arr, target, idx + 1, sum + arr[idx]);
        return dp[idx][sum+1010]=subtract + add;
    }
}