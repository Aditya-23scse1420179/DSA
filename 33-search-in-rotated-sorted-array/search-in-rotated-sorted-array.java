class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=(l+r)>>1;
            if(nums[mid]==target)return mid;
            if(nums[mid]>=nums[l]){//left part is sorted
                if(target>=nums[l]&&target<nums[mid]){
                    r=mid-1;//left
                }else{
                    l=mid+1;//right
                }
            }else{//right part is sorted
                if(target>nums[mid]&&target<=nums[r]){
                    l=mid+1;//right
                }else{
                    r=mid-1;//left
                }
            }
        }
        return -1;
    }
}