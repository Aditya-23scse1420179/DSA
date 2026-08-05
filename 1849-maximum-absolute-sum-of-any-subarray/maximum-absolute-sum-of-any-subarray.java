class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int cmin=nums[0],cmax=nums[0],max=nums[0],min=nums[0];
        for(int i=1;i<nums.length;i++){
            cmin=Math.min(nums[i],cmin+nums[i]);
            cmax=Math.max(nums[i],cmax+nums[i]);
            max=Math.max(max,cmax);
            min=Math.min(cmin,min);
        }
        return Math.max(max,Math.abs(min));
    }
}