class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] min = new int[nums.length];
        min[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min[i-1]){
                min[i]=nums[i];
            }else{
                min[i]=min[i-1];
            }
        }
        int[] max = new int[nums.length];
        max[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>max[i+1]){
                max[i]=nums[i];
            }else{
                max[i]=max[i+1];
            }
        }
        for(int i=1;i<nums.length-1;i++){
            if(min[i-1]<nums[i] && nums[i]<max[i+1])return true;
        }
        return false;
    }
}