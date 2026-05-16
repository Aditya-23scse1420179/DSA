class Solution {
    public int findMin(int[] nums) {
        int l=0,h=nums.length-1;
        while(l<h){
            int  mid=l+h>>1;
            if(nums[mid]<nums[h]){
                h=mid;
            }
            else if(nums[mid]>nums[h]){
                l=mid+1;
            }
            else{
                h--;
            }
        }
        return nums[l];
        
    }
}