class Solution {
    public int maxProduct(int[] nums) {
        int pre_sum = 1;
        int suf_sum = 1;
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            if(pre_sum == 0) pre_sum = 1;
            if(suf_sum == 0) suf_sum = 1;
            pre_sum *= nums[i];
            suf_sum *= nums[n-1-i];
            maxSum = Math.max(maxSum,Math.max(pre_sum,suf_sum));
        } 
        return maxSum;
    }
}