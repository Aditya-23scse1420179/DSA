class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int total=0,left=0,right=2;
        while(right<nums.length){
            int diff=nums[left+1]-nums[left];
            if(nums[right]-nums[right-1]==diff){
                total+=(right-left-1);
                right++;
            }else{
                left=right-1;
                right=left+2;
            }
        }
        return total;
    }
}