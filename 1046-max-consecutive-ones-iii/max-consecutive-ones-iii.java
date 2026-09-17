class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,max=0,ze=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0)ze++;
            while(ze>k){
                if(nums[left]==0)ze--;
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}