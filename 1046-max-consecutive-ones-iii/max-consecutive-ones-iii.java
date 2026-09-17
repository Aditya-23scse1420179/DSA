class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,max=0,one=0,ze=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==1)one++;
            if(nums[right]==0)ze++;
            if(ze>k){
                if(nums[left]==0)ze--;
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}