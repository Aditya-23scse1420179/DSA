class Solution {
    public int helper(int[] nums, int start, int end) {
        int prev = 0;    
        int prev2 = 0;   
        for (int i =start;i <= end;i++) {
            int pick = nums[i] +prev2;
            int skip =prev;
            int curr =Math.max(pick, skip);
            prev2 =prev;
            prev =curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n =nums.length;
        if (n ==1)return nums[0];
        if (n ==2)return Math.max(nums[0], nums[1]);
        int ans1 =helper(nums,1, n - 1);
        int ans2 =helper(nums,0, n - 2);
        return Math.max(ans1,ans2);
    }
}
