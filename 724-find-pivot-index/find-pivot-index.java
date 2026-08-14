class Solution {
    public int pivotIndex(int[] nums) {
        int lsum=0,sum=0;
        for(int a:nums){
            sum+=a;
        }
        for(int i=0;i<nums.length;i++){
            int rsum=sum-lsum-nums[i];
            if(lsum==rsum)return i;
            lsum+=nums[i];
        }

        return -1;
    }
}