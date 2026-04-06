class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currmax=nums[0];
        int currmin=nums[0];
        int maxs=nums[0];
        int mins=nums[0];
        int total=nums[0];
        for(int i=1;i<nums.length;i++){
            currmax=Math.max(nums[i],nums[i]+currmax);
            maxs=Math.max(maxs,currmax);
            currmin=Math.min(nums[i],nums[i]+currmin);
            mins=Math.min(mins,currmin);
            total+=nums[i];
        }
        if(mins==total)return maxs;
        return Math.max(maxs,total-mins);
    }
}