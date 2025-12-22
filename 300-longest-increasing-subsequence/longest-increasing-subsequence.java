class Solution {
    int[] nums;
    int n;
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        dp = new Integer[n][n + 1]; 
        return dfs(0, -1);
    }
    private int dfs(int i, int prevIndex) {
        if (i == n) return 0;
        if (dp[i][prevIndex + 1] != null)
            return dp[i][prevIndex + 1];
        // not take
        int res = dfs(i + 1, prevIndex);
        // take
        if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
            res = Math.max(res, 1 + dfs(i + 1, i));
        }
        return dp[i][prevIndex + 1] = res;
    }
}
