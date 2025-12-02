class Solution {
    public int helper (int[] nums, int s, int l) {
        int last = nums[s];             
        int prev = Math.max(nums[s], nums[s+1]);   
        for(int i = s+2;i <l;i++){
            int curr = Math.max(prev, nums[i] + last);
            last =prev;
            prev =curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        if(nums.length ==1) return nums[0];
        if(nums.length ==2)return Math.max(nums[0], nums[1]);
        int ans1 =helper(nums,1, nums.length);
        int ans2 =helper(nums,0, nums.length - 1);
        return Math.max(ans1,ans2);
    }
}
