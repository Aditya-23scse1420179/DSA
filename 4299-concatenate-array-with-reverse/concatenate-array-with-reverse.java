class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n=nums.length;
        int[]arr=new int[2*nums.length];
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
        }
        for(int i=0;i<n;i++){
            arr[n+i]=nums[n-i-1];
        }
        return arr;
    }
}