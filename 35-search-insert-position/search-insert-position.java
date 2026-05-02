class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int low=0,right=n-1;
        while(low<=right){
            int mid=(low+right)>>1;
            if(nums[mid]==target)return mid;
            else if(nums[mid]>target){
                right=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
}