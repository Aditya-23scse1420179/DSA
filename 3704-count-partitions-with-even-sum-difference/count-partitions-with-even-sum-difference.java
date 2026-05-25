class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int csum=0,total=0;
        int count=0;

        for(int a:nums){
            total+=a;
        }
        for(int i=0;i<n-1;i++){
            csum+=nums[i];
            int rsum=total-csum;
            if((csum-rsum)%2==0)count++;
        }
        return count;
    }
}