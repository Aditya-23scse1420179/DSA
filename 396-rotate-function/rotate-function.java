class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0, F0 = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F0 += (long)i * nums[i];
        }
        long max = F0;
        long curr = F0;
        for (int k = 1; k < n; k++) {
            curr = curr + sum - (long)n * nums[n - k];
            max = Math.max(max, curr);
        }
        
        return (int)max;
    }
}
