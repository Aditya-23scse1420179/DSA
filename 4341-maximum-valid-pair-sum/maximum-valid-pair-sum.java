class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int max=nums[0];
        int ans=-(int)1e9;
        for(int j=k;j<nums.length;j++){
            max=Math.max(max,nums[j-k]);
            ans=Math.max(ans,max+nums[j]);
        }
        return ans;
    }
}