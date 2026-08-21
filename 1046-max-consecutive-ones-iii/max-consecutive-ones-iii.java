class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0,l=0,ze=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)ze++;
            while(ze>k){
                if(nums[l]==0){
                    ze--;
                }
                l++;
            }
                max=Math.max(max,i-l+1);
            
        }
        return max;
    }
}