class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        helper(nums,0,nums.length-1);
        helper(nums,k,nums.length-1);
        helper(nums,0,k-1);
        
    }
    public void helper(int[]nums,int left,int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }    
    }
}