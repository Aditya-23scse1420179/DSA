class Solution {
    public int findMin(int[] nums) {
        int min=(int)1e9;
        int n=nums.length;
        for(int i=0;i<n;i++){
            min=Math.min(nums[i],min);
        }
        return min;
    }
}