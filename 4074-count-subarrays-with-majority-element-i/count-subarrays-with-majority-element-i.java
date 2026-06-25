class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int f=0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==target)f++;
            
                int length=j-i+1;
                if(2*f>length)count++;
            }
        }
        return count;
    }
}