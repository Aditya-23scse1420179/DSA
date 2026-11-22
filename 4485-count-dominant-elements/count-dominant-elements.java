class Solution {
    public int countDominantElements(int[] nums) {
        int n=nums.length;
        int c=0;
        if(nums.length==1)return 1;
        if(nums[0]>=nums[1])c++;
        if(nums[nums.length-1]>=nums[nums.length-2])c++;
        for(int i=1;i<n-1;i++){
            double a=(long)(nums[i-1]+nums[i+1])/2.0;
            if(nums[i]>=a)c++;
        }
        return c;
    }
}