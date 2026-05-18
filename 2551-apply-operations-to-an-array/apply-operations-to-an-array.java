class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
            }
        }
        move(nums);
        return nums;
    }public void move(int[] nums) {
        int i = 0;
        for (int j = 0;j<nums.length;j++) {
            if (nums[j] != 0){
                if (i!=j){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                i++;
            }
        }
    }
}