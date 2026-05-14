class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int csum=0;
        int max=nums[0];
        int cmin=0;
        int min=nums[0];
        int total=0;
        for(int a:nums){
            csum=Math.max(a,csum+a);
            max=Math.max(max,csum);
            cmin=Math.min(a,cmin+a);
            min=Math.min(min,cmin);
            total+=a;
        }
        if(max<0)return max;
        return Math.max(max,total-min);
    }
}